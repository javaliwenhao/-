package cn.kgc;

import java.util.Scanner;

public class chlm {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] names = new String[4];     // 保存订餐人名称
	    String[] dishMegs = new String[4];  // 保存菜品名及份数
	    int[] times = new int[4];           // 保存送餐时间
	    String[] add = new String[4]; // 保存送餐地址
	    int[] states = new int[4];          // 保存订单状态： 0：已预订 1：已完成
	    double[] sumP = new double[4]; // 保存订单的总金额
	    //初始订单
	    names[0]="李强";
        dishMegs[0]="狮子头1份";
        times[0]=12;
        add[0]="文鼎大厦16楼";
        states[0]=0;
        sumP[0]=10.00;
        
        names[1]="李刚";
        dishMegs[1]="鸡腿饭1份";
        times[1]=12;
        add[1]="文鼎大厦16楼";
        states[1]=0;
        sumP[1]=10.00;
        
        String[] dishNames = { "红烧带鱼", "鱼香肉丝", "时令鲜蔬" }; // 菜品名称
 		double[] prices = new double[] { 38.0, 20.0, 10.0 }; // 菜品单价
 		int[] praiseNums = new int[3];
 		
        boolean goOn=false;
        //循环输入菜单，输入要选择的功能 
        do{ 
        	//显示菜单
        	goOn=false;
            System.out.println("****************************");
			System.out.println("1、我要订餐");
			System.out.println("2、查看餐袋");
			System.out.println("3、签收订单");
			System.out.println("4、删除订单");
			System.out.println("5、我要点赞");
			System.out.println("6、退出系统");
			System.out.println("****************************");
			System.out.print("请选择：");
			int a= input.nextInt();    //用户选择功能输入
			boolean isAdd = false;     //记录是否可以订餐
	        boolean isSignFind = false;  //找到要签收的订单
	        
	        //根据输入，选择相应的功能
			switch(a){
	        case 1:
	        	// 我要订餐
				System.out.println("***我要订餐***");
				for (int j = 0; j < names.length; j++) {					
                   if(names[j] == null){  //找到第一个空位置，可以添加订单信息
                	   isAdd = true;  //置标志位，可以订餐
                	   System.out.print("请输入订餐人姓名：");
   					String name = input.next(); 
					// 显示供选择的菜品信息
					System.out.println("序号" + "\t" + "菜名"+"\t"+"单价");
					for (int i = 0; i < dishNames.length; i++) {
						String price = prices[i] + "元";
						String priaiseNum = (praiseNums[i]) > 0 ? praiseNums[i]
								+ "赞" : "";
						
						System.out.println((i + 1) + "\t" + dishNames[i] + "\t"	+price+"\t"+ priaiseNum);
					}
					// 用户点菜
					System.out.print("请选择您要点的菜品编号:");
					int chooseDish = input.nextInt();
					System.out.print("请选择您需要的份数:");
					int number = input.nextInt();
					String dishMeg =  dishNames[chooseDish - 1]
							+" "+ number + "份";
					double sumPrice = prices[chooseDish - 1] * number;
					//餐费满50元，免送餐费10元
					double deliCharge = (sumPrice>=50)?0:6;                   

					System.out.print("请输入送餐时间（送餐时间是10点至20点间整点送餐）:");
					int time = input.nextInt();
					while (time < 10 || time > 20) {
						System.out.print("您的输入有误，请输入10~20间的整数！");
						time = input.nextInt();
					}
					System.out.print("请输入送餐地址：");
					String address = input.next();
										
					//无需添加状态，默认是0，即已预定状态。
					System.out.println("订餐成功！");
					System.out.println("您订的是："+dishMeg);
					System.out.println("送餐时间："+time+"点");
					System.out.println("餐费："+sumPrice+"元，送餐费"+deliCharge+"元，总计："+(sumPrice+deliCharge)+"元。");
					
					//添加数据
					names[j] = name;
					dishMegs[j] = dishMeg;
					times[j] = time;
					add[j] = address;
					sumP[j] = sumPrice+deliCharge;
					break;
					}
				}
				if(!isAdd){
					System.out.println("对不起，您的餐袋已满！");
				}
				break;
	        case 2:
	        	System.out.println("查看餐袋");
	        	for(int i=0;1<names.length;i++){
	        		System.out.println("姓名:"+names[i]);
	    			System.out.println("菜名"+dishMegs[i]);
	    			System.out.println("配送时间"+times[i]);
	    			System.out.println("地址"+add[i]);
	    			System.out.println("菜单状态"+states[i]);
	    			System.out.println("总金额"+sumP[i]);
	        	}
	        	break;
	        case 3:
	        	//签收订单
	        	System.out.print("请选择要签收的订单序号：");
				int signOrderId = input.nextInt();
				for(int i=0;i<names.length;i++){
					//状态为已预定，序号为用户输入的订单序号：可签收
					//状态为已完成，序叼为用户输入胡订单序号：不可签收				
					if(names[i]!=null && states[i]==0 && signOrderId==i+1){
						states[i] = 1; 
						System.out.println("订单签收成功！");
						isSignFind = true;
					}else if(names[i]!=null && states[i]==1 && signOrderId==i+1){
						System.out.println("您选择的订单已完成签收，不能再次签收！");
						isSignFind = true;
					}
				}
				//未找到的订单序号：不可签收
				if(!isSignFind){
					System.out.println("您选择的订单不存在！");
				}
	        	break;
	        case 4:
	        	// 删除订单
				System.out.println("***删除订单***");
				System.out.print("请输入要删除的订单序号:");
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
						System.out.print("删除定单成功");
					}else{
						System.out.print("订单未完成，不能删除");
					}
				}
				System.out.print("订单不存在，无法删除");
						
	        	break;
	        case 5:
				System.out.println("我要点赞");
				System.out.println("序号"+"\t"+"菜名"+"\t"+"单价");
				for (int i=0;i<dishNames.length;i++) {
					String priaiseNum=(praiseNums[i])>0?praiseNums[i]+"赞":"0赞";
					System.out.println((i+1)+"\t"+dishNames[i]+"\t"+prices[i]+"元"+"\t"+ priaiseNum);
				}
				//输入要点赞的菜品的编号id
				System.out.println("请输入您要点赞的菜品编号:");
				id = input.nextInt();
				praiseNums[id-1]++;  //对应下标的菜品赞数加1
				System.out.println("点赞成功！");
	        	break;
	        case 6:
	        	System.out.println("退出系统");
	        	System.exit(0);//停止运行
	        	break;
	        	
	        default:
	        	System.out.println("退出系统");
	        	break;
	        }
	       	System.out.println("是否返回菜单，输入0返回菜单");
	       	a=input.nextInt();
	       	if (a==0){
	    	   goOn=true;
	       	}
        } while(goOn);
        
        
        
        
        
	}

}
