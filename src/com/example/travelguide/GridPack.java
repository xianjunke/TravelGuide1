package com.example.travelguide;
/************************
 * ������GridPack<br>
 * ���ܣ�������Ϣ��װ��<br>
 * �����¼���
 * @author xjk
 * 
 ************************/
public class GridPack 
{
	/**����ͼƬ��ͣ��ʱ��*/
	private int time;
	/**�жϷ����Ƿ���ͼƬ*/
	private int isImg;

	/**
	 * �������ƣ�setTime<br>
	 * �������ܣ����÷���ͼƬ��ͣ��ʱ��
	 * 
	 * @param int time
	 * @author  xjk
	 * @return ��
	 */
	public void setTime(int time)
	{
		this.time = time;
	}
	
	/**
	 * �������ƣ�getTime<br>
	 * �������ܣ���÷���ͼƬ��ͣ��ʱ��
	 * 
	 * @param ��
	 * @author  xjk
	 * @return int
	 */
	public int getTime()
	{
		return time;
	}
	
	/**
	 * �������ƣ�setIsImg<br>
	 * �������ܣ����á������Ƿ���ͼƬ������Ϣ
	 * 
	 * @param int isImg
	 * @author  xjk
	 * @return ��
	 */
	public void setIsImg(int isImg)
	{
		this.isImg = isImg;
	}
	
	/**
	 * �������ƣ�getIsImg<br>
	 * �������ܣ���á������Ƿ���ͼƬ������Ϣ
	 * 
	 * @param ��
	 * @author  xjk
	 * @return int
	 */
	public int getIsImg()
	{
		return isImg;
	}
}
