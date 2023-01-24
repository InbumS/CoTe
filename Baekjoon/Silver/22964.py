a,b,c,m=map(int,input().split())

ans=0
fatigue=0
time=1

for i in range(24):
    if fatigue+a<=m:
        fatigue+=a
        ans+=b     
        
    else:
        fatigue-=c
        if fatigue<0:
            fatigue=0
 

if a>m:
    print(0)
else:
    print(ans)
