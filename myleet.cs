//reverse array of char
public void lt_ReverseString(char[] s) {
        if (s?.Length != 1)
        {      
           int l=s.Length;
           for (int i=0;i<l/2;i++) {
             char tmp=s[i];
             s[i]=s[l-1-i];
             s[l-1-i]=tmp;
           }
        } 
    }