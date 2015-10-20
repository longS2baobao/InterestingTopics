package IT.Datastructure.String;

//This implementation consider "dog" is a permutation to "god" , not to "ogd"
//given two string check if one is a permutation to the other
public class Permutation {

	public Permutation(){	}
	
	//e.g return true if s1 = "dog" and s2 = "god"
	public boolean isPermute(String s1, String s2)
	{
		//two strings must be same in length
		if(s1.length()!= s2.length()) return false;
		
		int length = s1.length();
		char[] ca_s1 = s1.toCharArray();
		char[] ca_s2=s2.toCharArray();
		for (int i =0; i<length; i++)
		{
			if (ca_s1[i] != ca_s2[length-i-1]) return false;	
		}
		return true;
	}
	
	//function to check if the given string is self permute
	public boolean isPermute(String s)
	{
		char[] ca_s=s.toCharArray();
		int length = s.length();
		int middle = length/2;

		for(int i=0;i<middle;i++)
		{
			if(ca_s[i] != ca_s[length-i-1]) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Permutation p = new Permutation();
		System.out.println(p.isPermute("abcdef","fedcba"));
		System.out.println(p.isPermute("abccba"));
	}

}
