package com.lixuan.zte;
public class RotatePicture
{
	public static void main(String[] args)
	{
		int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
		for(int i = 0; i< arr.length; i++)
		{
			for(int j = 0; j < arr.length; j++)
			{
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		int[][] result = rotate(arr, 0);
		for(int i = 0; i< result.length; i++)
		{
			for(int j = 0; j < result.length; j++)
			{
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static int[][] rotate(int[][] matrix, int flag)
	{
		int N = matrix.length;
		int[][] result = new int[N][N]; 
		if(flag == 1)//左旋
		{
			for(int i = 0; i < N; i++)  
	        {  
				for(int j = 0; j < N; j++){
					result[i][j] = matrix[j][N - 1 - i];
				}
	        }  
		}
		if(flag == 0)//右旋
		{
			for(int i = 0; i < N; i++)  
	        {  
				for(int j = 0; j < N; j++)
				{
					result[i][j] = matrix[N - 1- j][i];
				}
	        }  
		}
		return result;
	}
}
