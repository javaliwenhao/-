package cn.kgc;

import java.util.Scanner;

public class chlm {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] names = new String[4];     // ���涩��������
	    String[] dishMegs = new String[4];  // �����Ʒ��������
	    int[] times = new int[4];           // �����Ͳ�ʱ��
	    String[] add = new String[4]; // �����Ͳ͵�ַ
	    int[] states = new int[4];          // ���涩��״̬�� 0����Ԥ�� 1�������
	    double[] sumP = new double[4]; // ���涩�����ܽ��
	    //��ʼ����
	    names[0]="��ǿ";
        dishMegs[0]="ʨ��ͷ1��";
        times[0]=12;
        add[0]="�Ķ�����16¥";
        states[0]=0;
        sumP[0]=10.00;
        
        names[1]="���";
        dishMegs[1]="���ȷ�1��";
        times[1]=12;
        add[1]="�Ķ�����16¥";
        states[1]=0;
        sumP[1]=10.00;
        
        String[] dishNames = { "���մ���", "������˿", "ʱ������" }; // ��Ʒ����
 		double[] prices = new double[] { 38.0, 20.0, 10.0 }; // ��Ʒ����
 		int[] praiseNums = new int[3];
 		
        boolean goOn=false;
        //ѭ������˵�������Ҫѡ��Ĺ��� 
        do{ 
        	//��ʾ�˵�
        	goOn=false;
            System.out.println("****************************");
			System.out.println("1����Ҫ����");
			System.out.println("2���鿴�ʹ�");
			System.out.println("3��ǩ�ն���");
			System.out.println("4��ɾ������");
			System.out.println("5����Ҫ����");
			System.out.println("6���˳�ϵͳ");
			System.out.println("****************************");
			System.out.print("��ѡ��");
			int a= input.nextInt();    //�û�ѡ��������
			boolean isAdd = false;     //��¼�Ƿ���Զ���
	        boolean isSignFind = false;  //�ҵ�Ҫǩ�յĶ���
	        
	        //�������룬ѡ����Ӧ�Ĺ���
			switch(a){
	        case 1:
	        	// ��Ҫ����
				System.out.println("***��Ҫ����***");
				for (int j = 0; j < names.length; j++) {					
                   if(names[j] == null){  //�ҵ���һ����λ�ã�������Ӷ�����Ϣ
                	   isAdd = true;  //�ñ�־λ�����Զ���
                	   System.out.print("�����붩����������");
   					String name = input.next(); 
					// ��ʾ��ѡ��Ĳ�Ʒ��Ϣ
					System.out.println("���" + "\t" + "����"+"\t"+"����");
					for (int i = 0; i < dishNames.length; i++) {
						String price = prices[i] + "Ԫ";
						String priaiseNum = (praiseNums[i]) > 0 ? praiseNums[i]
								+ "��" : "";
						
						System.out.println((i + 1) + "\t" + dishNames[i] + "\t"	+price+"\t"+ priaiseNum);
					}
					// �û����
					System.out.print("��ѡ����Ҫ��Ĳ�Ʒ���:");
					int chooseDish = input.nextInt();
					System.out.print("��ѡ������Ҫ�ķ���:");
					int number = input.nextInt();
					String dishMeg =  dishNames[chooseDish - 1]
							+" "+ number + "��";
					double sumPrice = prices[chooseDish - 1] * number;
					//�ͷ���50Ԫ�����Ͳͷ�10Ԫ
					double deliCharge = (sumPrice>=50)?0:6;                   

					System.out.print("�������Ͳ�ʱ�䣨�Ͳ�ʱ����10����20��������Ͳͣ�:");
					int time = input.nextInt();
					while (time < 10 || time > 20) {
						System.out.print("������������������10~20���������");
						time = input.nextInt();
					}
					System.out.print("�������Ͳ͵�ַ��");
					String address = input.next();
										
					//�������״̬��Ĭ����0������Ԥ��״̬��
					System.out.println("���ͳɹ���");
					System.out.println("�������ǣ�"+dishMeg);
					System.out.println("�Ͳ�ʱ�䣺"+time+"��");
					System.out.println("�ͷѣ�"+sumPrice+"Ԫ���Ͳͷ�"+deliCharge+"Ԫ���ܼƣ�"+(sumPrice+deliCharge)+"Ԫ��");
					
					//�������
					names[j] = name;
					dishMegs[j] = dishMeg;
					times[j] = time;
					add[j] = address;
					sumP[j] = sumPrice+deliCharge;
					break;
					}
				}
				if(!isAdd){
					System.out.println("�Բ������Ĳʹ�������");
				}
				break;
	        case 2:
	        	System.out.println("�鿴�ʹ�");
	        	for(int i=0;1<names.length;i++){
	        		System.out.println("����:"+names[i]);
	    			System.out.println("����"+dishMegs[i]);
	    			System.out.println("����ʱ��"+times[i]);
	    			System.out.println("��ַ"+add[i]);
	    			System.out.println("�˵�״̬"+states[i]);
	    			System.out.println("�ܽ��"+sumP[i]);
	        	}
	        	break;
	        case 3:
	        	//ǩ�ն���
	        	System.out.print("��ѡ��Ҫǩ�յĶ�����ţ�");
				int signOrderId = input.nextInt();
				for(int i=0;i<names.length;i++){
					//״̬Ϊ��Ԥ�������Ϊ�û�����Ķ�����ţ���ǩ��
					//״̬Ϊ����ɣ����Ϊ�û������������ţ�����ǩ��				
					if(names[i]!=null && states[i]==0 && signOrderId==i+1){
						states[i] = 1; 
						System.out.println("����ǩ�ճɹ���");
						isSignFind = true;
					}else if(names[i]!=null && states[i]==1 && signOrderId==i+1){
						System.out.println("��ѡ��Ķ��������ǩ�գ������ٴ�ǩ�գ�");
						isSignFind = true;
					}
				}
				//δ�ҵ��Ķ�����ţ�����ǩ��
				if(!isSignFind){
					System.out.println("��ѡ��Ķ��������ڣ�");
				}
	        	break;
	        case 4:
	        	// ɾ������
				System.out.println("***ɾ������***");
				System.out.print("������Ҫɾ���Ķ������:");
				int id = input.nextInt();
				if(id<=names.length&&id>=1&&names[id-1]!=null){
					if(states[id-1]==1){
						for(int j=id-1;j<names.length-1;j++){
							names[j] = names[j+1];
							dishMegs[j] = dishMegs[j+1];
							times[j] = times[j+1];
							add[j] = add[j+1];
							states[j] = states[j+1];
						}
						names[names.length-1] = null;
						dishMegs[names.length-1] = null;
						times[names.length-1] = 0;
						add[names.length-1] = null;
						states[names.length-1] = 0;
						System.out.print("ɾ�������ɹ�");
					}else{
						System.out.print("����δ��ɣ�����ɾ��");
					}
				}
				System.out.print("���������ڣ��޷�ɾ��");
						
	        	break;
	        case 5:
				System.out.println("��Ҫ����");
				System.out.println("���"+"\t"+"����"+"\t"+"����");
				for (int i=0;i<dishNames.length;i++) {
					String priaiseNum=(praiseNums[i])>0?praiseNums[i]+"��":"0��";
					System.out.println((i+1)+"\t"+dishNames[i]+"\t"+prices[i]+"Ԫ"+"\t"+ priaiseNum);
				}
				//����Ҫ���޵Ĳ�Ʒ�ı��id
				System.out.println("��������Ҫ���޵Ĳ�Ʒ���:");
				id = input.nextInt();
				praiseNums[id-1]++;  //��Ӧ�±�Ĳ�Ʒ������1
				System.out.println("���޳ɹ���");
	        	break;
	        case 6:
	        	System.out.println("�˳�ϵͳ");
	        	System.exit(0);//ֹͣ����
	        	break;
	        	
	        default:
	        	System.out.println("�˳�ϵͳ");
	        	break;
	        }
	       	System.out.println("�Ƿ񷵻ز˵�������0���ز˵�");
	       	a=input.nextInt();
	       	if (a==0){
	    	   goOn=true;
	       	}
        } while(goOn);
        
        
        
        
        
	}

}
