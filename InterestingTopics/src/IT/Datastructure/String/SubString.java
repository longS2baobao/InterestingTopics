package IT.Datastructure.String;

// isRotation and LCS
public class SubString {
	private String s1;
	private String s2;
	public SubString()
	{
	}
	public SubString(String s1, String s2)
	{
		this.s1 = s1;
		this.s2 = s2;
	}
	
	//i.e "erbottlewat" is a rotation of "waterbottle"
	public boolean isRotation()
	{
		return isRotation(s1,s2);
	}
	
	//Strategy: s2 is a rotation of s1 <==> s2 is a substring of s1s1
	public boolean isRotation(String s1,String s2)
	{
		if (s1.length() == s2.length()&&s1.length()!=0 )
		{
			String s1s1 = s1+s1;
			return s1s1.contains(s2)?true:false;
		}
		return false;
	}
	
	public String LCS()
	{
		return LCS(s1,s2);
	}
	
	// Longest Common Subsequence : i.e LCS for "BANANA" and "ATANA" is "AANA"
	// Dynamic Programming£ºsubproblem solutions are memorised rather than computed over and over
	public String LCS(String s1, String s2)
	{
		return "To be implemented";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "erbottlewat";
		String s2 = "waterbottle";
		SubString ss = new SubString(s1,s2);
		System.out.println(ss.isRotation());
		
		
	}

}
