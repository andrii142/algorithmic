#include<iostream>
#include<vector>
#include<map>
#include<algorithm>
#include<set>
#define M 200008
#define N 200008
#define block_size 500
using namespace std;
pair<int,int>edges[M];
vector<pair<pair<int,int>,int > >large_q[M/block_size+5];
vector<pair<pair<int,int>,int > >small_q[M/block_size+5];
int Paren[N];

pair<int,int> history[10*M];
int siz_h;
void createset(int x)
{
	Paren[x]=x;
}
int find_parent(int x)
{
	if(x==Paren[x])
		return x;
	history[siz_h++]=make_pair(x,Paren[x]);
	Paren[x]=find_parent(Paren[x]);
	return Paren[x];
}
int merge(int x,int y)
{
	int u=find_parent(x);
	int v=find_parent(y);
	if(v==u)
		return 0;
	if(u>v)
	{
		history[siz_h++]=make_pair(u,Paren[u]);
		Paren[u]=v;
	}
	else
	{
		history[siz_h++]=make_pair(v,Paren[v]);
		Paren[v]=u;
	}
	return 1;
}
void rollback()
{
	while(siz_h)
	{
		Paren[history[siz_h-1].first]=history[siz_h-1].second;
		siz_h--;
	}
}
int solution[M];
int main()
{
	int t;
	ios_base::sync_with_stdio(false);cin.tie(0);
	cin>>t;
	while(t--)
	{
		int n,m,q,x,y;
		cin>>n>>m>>q;
		for(int i=0;i<=m/block_size;i++)
		{
			small_q[i].clear();
			large_q[i].clear();
		}
		for(int i=1;i<=m;i++)
		{
			cin>>edges[i].first>>edges[i].second;
		}
		for(int i=1;i<=q;i++)
		{
			cin>>x>>y;
			if(x/block_size==y/block_size)
			{
				small_q[x/block_size].push_back(make_pair(make_pair(x,y),i));
			}
			else large_q[x/block_size].push_back(make_pair(make_pair(y,x),i));
		}
		for(int i=1;i<=n;i++)
			createset(i);
		//small_queries
		for(int i=0;i<=m/block_size;i++)
		{
			for(int j=0;j<small_q[i].size();j++)
			{
				int con=n;
				siz_h=0;
				for(int k=small_q[i][j].first.first;k<=small_q[i][j].first.second;k++)
				{
					con-=merge(edges[k].first,edges[k].second);
				}
				solution[small_q[i][j].second]=con;
				rollback();
			}
		}
		//large_queries
		for(int i=0;i<=m/block_size;i++)
		{
			sort(large_q[i].begin(),large_q[i].end());
		}
		for(int i=0;i<=m/block_size;i++)
		{
			for(int i=1;i<=n;i++)
			createset(i);
			int r=(i+1)*block_size-1,con=n;
			for(int j=0;j<large_q[i].size();j++)
			{
				//cout<<"doing:"<<large_q[i][j].second<<endl;
				while(large_q[i][j].first.first>r)
				{
					r++;
					siz_h=0;
					con-=merge(edges[r].first,edges[r].second);
				}
				int l=(i+1)*block_size,con2=0;
				siz_h=0;
				while(large_q[i][j].first.second<l)
				{
					l--;
					con2+=merge(edges[l].first,edges[l].second);
				}
				solution[large_q[i][j].second]=con-con2;
				rollback();
			}
		}
		for(int i=1;i<=q;i++)
			cout<<solution[i]<<"\n";
	}
}