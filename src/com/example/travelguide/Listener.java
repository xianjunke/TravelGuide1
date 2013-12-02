package com.example.travelguide;



import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

/************************
 * ������Listener<br>
 * ���ܣ����Ĵ����࣬�Ӵ��������ӿ�<br>
 * �����¼���
 * @author xianjunke
 * 
 ************************/
public class Listener implements OnClickListener 
{
	/**����*/
	private int score = 0;
	/**��ʱ��*/
	private int time = 0;
	/**����ʱ*/
	private int DownTime = 100;
	/**ͼƬ��ť  ������Ϸ����*/
	private ImageButton imageBtn[] = new ImageButton[20];
	/**���ա������·�����Ϣ���з���ͼƬ*/
	private Handler handler =  new Handler()
	{
		public void handleMessage(Message msg)
		{
			imageBtn[msg.what].setBackgroundResource(R.drawable.ai);
		}
	};
	/**���ա������·�����Ϣ������͸�������޷���ͼƬ*/
	private Handler handler1 =  new Handler()
	{
		public void handleMessage(Message msg)
		{
			//R.drawable.tra ͸��
			imageBtn[msg.what].setBackgroundResource(R.drawable.tra);
		}
	};
	/**���ա������·�����Ϣ*/
	private Handler handler_score =  new Handler()
	{
		public void handleMessage(Message msg)
		{
			int s = score++;
			String score = String.valueOf(s);
			text_score.setText(score);//���ò����·����ı���
		}
	};
	/**���ա������µ���ʱ��Ϣ��������Ϸ����*/
	private Handler handler_time =  new Handler()
	{
		public void handleMessage(Message msg)
		{
			if(DownTime > 0)
			{
				String time = String.valueOf(DownTime--);
				text_time.setText(time);
				if(DownTime <= 0)
				{
					gameover();//��Ϸ����ʱ����
				}
			}
		}

	};
	/**���ֵ�20��ͼƬ��ť*/
	private int imgBtnId[] =
		{
			R.id.imageButton0,R.id.imageButton1,R.id.imageButton2,R.id.imageButton3,R.id.imageButton4,
			R.id.imageButton5,R.id.imageButton6,R.id.imageButton7,R.id.imageButton8,R.id.imageButton9,
			R.id.imageButton10,R.id.imageButton11,R.id.imageButton12,R.id.imageButton13,R.id.imageButton14,
			R.id.imageButton15,R.id.imageButton16,R.id.imageButton17,R.id.imageButton18,R.id.imageButton19
		};
	/**���塰��װ������Ϣ���������*/
	private GridPack gridPack[] = new GridPack[20];
	/**���嵹��ʱ�ı���*/
	private TextView text_time;
	/**��������ı���*/
	private TextView text_score;
	/**����WolfShootingActivity��*/
	private WolfShootingActivity ws;
	
	/**
	 * �������ƣ�Listener<br>
	 * �������ܣ����캯��
	 * 
	 * @param ws
	 * @author  xjk
	 * @return ��
	 */
	public Listener(WolfShootingActivity ws) 
	{
		this.ws = ws;
		for(int i = 0; i <= 19; i++)
		{
			//��÷������
			imageBtn[i] = (ImageButton) ws.findViewById(imgBtnId[i]);
			//���ü�����
			imageBtn[i].setOnClickListener(this);
			//Ϊÿ�����鴴��������Ϣ
			gridPack[i] = new GridPack();
			
		}
		//��÷����ı������
		text_score = (TextView)ws.findViewById(R.id.text_score);
		//��õ���ʱ�ı������
		text_time = (TextView)ws.findViewById(R.id.text_time);
        //�������������߳�
		new Thread()
        {
			public void run()
        	{
				while(true)
				{
	        		try
	        		{
						Thread.sleep(100);
						upimg();//�������·�����Ϣ
						upDownTime();//�������µ���ʱ��Ϣ
						time++;//��ʱ���ۼ�
					}
	        		catch (InterruptedException e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
        	}

			
        }.start();
	}

	/**
	 * �������ƣ�upDownTime<br>
	 * �������ܣ����µ���ʱ��Ϣ
	 * 
	 * @param ��
	 * @author  xjk
	 * @return ��
	 */
	private void upDownTime() 
	{
		//ÿ��1����µ���ʱ
		if(time % 10 == 0)
		{
			Message msg = new Message();//�½���Ϣ
			handler_time.sendMessage(msg);//������Ϣ
		}
	}
	/**
	 * �������ƣ�upimg<br>
	 * �������ܣ����·�����Ϣ�����Ĵ���
	 * 
	 * @param ��
	 * @author  xjk
	 * @return ��
	 */
	private void upimg() 
	{
		create();//��������ͼƬ
		for(int i = 0; i <= 19; i++)
		{
			if(gridPack[i].getIsImg() == 1)//gridPack[i].getImg() == 1��ʾ�з���ͼƬ
			{
				gridPack[i].setTime(gridPack[i].getTime() + 1);//���·���ͼƬͣ��ʱ��
			}
			if(gridPack[i].getTime() >= 10)//ͣ��ʱ�䳬��1��
			{
				gridPack[i].setIsImg(0);//gridPack[i].setImg(0) ��������> (0��ʾ�޷���ͼƬ | 1��ʾ�з���ͼƬ)
				gridPack[i].setTime(0);//��������ͣ��ʱ��
				//���͡����·�����Ϣ�����ø÷���Ϊ͸����
				Message msg = new Message();
				msg.what = i;//������i
				handler1.sendMessage(msg);
			}
		}
	}

	/**
	 * �������ƣ�create<br>
	 * �������ܣ���������ͼƬ
	 * 
	 * @param ��
	 * @author  xjk
	 * @return ��
	 */
	private void create() 
	{
		if(time % 20 == 0)//��ʱ����ÿ��2��
		{
			crateI();//�������һ������ͼƬ
			
			if(time >= 100)//10��
			{
				for(int i = 0; i <= 1; i++)
				{
					crateI();
				}
			}
			if(time >= 200)//20��
			{
				for(int i = 0; i <= 1; i++)
				{
					crateI();
				}
			}
		}
	}

	
	/**
	 * �������ƣ�crateI<br>
	 * �������ܣ��������һ������ͼƬ
	 * 
	 * @param ��
	 * @author  xjk
	 * @return ��
	 */
	private void crateI() 
	{
		int num = (int) (Math.random()*20);//���������
		//���͡����·��顱��Ϣ
		Message msg = new Message();
		msg.what = num;//������
		handler.sendMessage(msg);
		gridPack[num].setIsImg(1);//���÷�����Ϣ-->�з���ͼƬ
	}

	//��д��ť�����¼�
	@Override
	public void onClick(View v)
	{
		for(int i =0; i <= 19; i++)
		{
			//v.getId() == imgBtnId[i] ȷ����һ���鴥��������
			//gridPack[i].getImg() == 1 ȷ�������Ƿ���ͼƬ
			if(v.getId() == imgBtnId[i] && gridPack[i].getIsImg() == 1)
			{
				gridPack[i].setIsImg(0);//�÷���������ͼƬ
				v.setBackgroundResource(R.drawable.tra);//����ͼƬ����Ϊ͸��
				//���͸��·�����Ϣ
				Message msg = new Message();
				handler_score.sendMessage(msg);
				break;
			}
		}
	}
	
	/**
	 * �������ƣ�gameover<br>
	 * �������ܣ���Ϸ����ʱ����
	 * 
	 * @param ��
	 * @author  xjk
	 * @return ��
	 */
	private void gameover() 
	{
		//�����Ի���
		new AlertDialog.Builder(ws)
		.setIcon(R.drawable.shuijing)//���öԻ���ͼ��
		.setTitle("Game over")//���ñ���
		.setMessage("Do you want to try again?")//��������
		//����ȡ����ť
		.setNegativeButton("exit", new DialogInterface.OnClickListener() 
		{
			@Override
			public void onClick(DialogInterface dialog, int which) 
			{
				System.exit(0);//�������̣��˳���̨
			}
		})
		//����ȷ����ť
		.setPositiveButton("Ok", new DialogInterface.OnClickListener() 
		{
			public void onClick(DialogInterface dialog, int whichButton)
			{
				DownTime = 100;//���õ���ʱ
				score = 0;//���÷���
				
			}
		}).show();//��ʾ�Ի���
		
	}
}
