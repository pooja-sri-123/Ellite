class Solution:
    def myAtoi(self, s: str) -> int:
        s=s.strip()
        if not s:
            return 0
        sign=1
        i=0
        if(s[i]=='+'):
            i+=1
        elif(s[i]=='-'):
            sign=-1
            i+=1
        res=0
        while(i<len(s)):
            if not s[i].isdigit():
                break
            else:
                res=res*10+int(s[i])
            i+=1
        res=res*sign
        if(res>=2**31):
            return 2**31-1
        elif(res<=-2**31):
            return -2**31
        else:
            return res
