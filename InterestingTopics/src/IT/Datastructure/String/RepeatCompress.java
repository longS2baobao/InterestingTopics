package IT.Datastructure.String;

//This class compress repeated chars to numbers
//e.g "aabcccccaaa" will be compressed to "a2b1c5a3"
public class RepeatCompress {

	public String compress(String s)
	{
		StringBuilder sb = new StringBuilder();
		char marker=s.charAt(0);
		int counter =1;
		for(int i =0;i<s.length();i++)
		{
			//new character
			if(s.charAt(i)!=marker)
			{
				if(i!=0) sb.append(counter);
				counter =1;			//reset counter
				marker = s.charAt(i);
				sb.append(marker);
			}
			else
			{
				counter ++;
			}
		}
		sb.append(counter);
		String compressed = sb.toString();
		if(compressed.length() >= s.length()) return s;
		return compressed;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RepeatCompress rc = new RepeatCompress();
		System.out.println(rc.compress("aabcccccaaa"));
		System.out.println(rc.compress("abc"));
	}

}
