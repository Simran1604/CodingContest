package contest2;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
public class cc2_i1 {
static class Reader {
final private int BUFFER_SIZE = 1 << 16;
private DataInputStream din;
private byte[] buffer;
private int bufferPointer, bytesRead;
public Reader()
{
din = new DataInputStream(System.in);
buffer = new byte[BUFFER_SIZE];
bufferPointer = bytesRead = 0;
}
public Reader(String file_name) throws IOException
{
din = new DataInputStream(
new FileInputStream(file_name));
buffer = new byte[BUFFER_SIZE];
bufferPointer = bytesRead = 0;
}
public String readLine() throws IOException
{
byte[] buf = new byte[64]; // line length
int cnt = 0, c;
while ((c = read()) != -1) {
if (c == '\n') {
if (cnt != 0) {
break;
}
else {
continue;
}
}
buf[cnt++] = (byte)c;
}
return new String(buf, 0, cnt);
}
public int nextInt() throws IOException
{
int ret = 0;
byte c = read();
while (c <= ' ') {
c = read();
}
boolean neg = (c == '-');
if (neg)
c = read();
do {
ret = ret * 10 + c - '0';
} while ((c = read()) >= '0' && c <= '9');
if (neg)
return -ret;
return ret;
}
public long nextLong() throws IOException
{
long ret = 0;
byte c = read();
while (c <= ' ')
c = read();
boolean neg = (c == '-');
if (neg)
c = read();
do {
ret = ret * 10 + c - '0';
} while ((c = read()) >= '0' && c <= '9');
if (neg)
return -ret;
return ret;
}
public double nextDouble() throws IOException
{
double ret = 0, div = 1;
byte c = read();
while (c <= ' ')
c = read();
boolean neg = (c == '-');
if (neg)
c = read();
do {
ret = ret * 10 + c - '0';
} while ((c = read()) >= '0' && c <= '9');
if (c == '.') {
while ((c = read()) >= '0' && c <= '9') {
ret += (c - '0') / (div *= 10);
}
}
if (neg)
return -ret;
return ret;
}
private void fillBuffer() throws IOException
{
bytesRead = din.read(buffer, bufferPointer = 0,
 BUFFER_SIZE);
if (bytesRead == -1)
buffer[0] = -1;
}
private byte read() throws IOException
{
if (bufferPointer == bytesRead)
fillBuffer();
return buffer[bufferPointer++];
}
public void close() throws IOException
{
if (din == null)
return;
din.close();
}
}
public static void main(String args[]) throws IOException
{
Reader s=new Reader();

int a[]={1,2,2,2,3,3,4,4,5,6,6,6,7};

int n=dup(a,a.length);

System.out.println(" ");
System.out.println(n);

}//main

static int dup(int a[],int n)
{
    if(n==0 ||n==1)
    return n;
    
    int j=0;
    int temp[]=new int[n];
    for(int i=0;i<n-1;i++)
    {
        if(a[i]!=a[i+1])
        temp[j++]=a[i];
    }
    temp[j++]=a[n-1];

    for(int i=0;i<j;i++)
    System.out.print(temp[i]+" ");

    return j;

}
}