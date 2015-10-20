package IT.Datastructure.Array;

//Given an image represented by an N*N matrix where each pixel in the image is 4 bytes. write a method to rotate the image by 90 degrees
public class ImageRotation {

	byte[][] image;
	public ImageRotation(byte[][] inputImage)
	{
		image = inputImage;
	}
	
	public void rotate()
	{
		int length = image[0].length;
		
		for (int layer =0;layer<length/2;layer++)
		{
			int first = layer;
			int last = length-1-layer;
			for(int i =first;i<last;i++)
			{
				int offset=i-first;
				
				//save top
				byte top = image[first][i];
				
				//left -> top
				image[first][i] = image[last-offset][first];
				
				//bottom -> left
				image[last-offset][first] = image[last][last-offset];
			
				//right -> bottom
				image[last][last-offset]=image[i][last];
				
				//top -> right
				image[i][last]=top;
				
			}
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
