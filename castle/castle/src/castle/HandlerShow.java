package castle;

public class HandlerShow extends Handler {

	public HandlerShow(Game game) {
		super(game);	
	}

	
	public int show(Room currentRoom) {
		int num = 0;
    	//进入不同房间说不同的话
    	if(currentRoom.getDes().equals("悬崖")){
			System.out.println("你掉下了悬崖，请重新开始！");			
		}
		else if(currentRoom.getDes().equals("老虎洞")){
			System.out.println("你掉进了陷阱，请重新开始！");			
		}
		else if(currentRoom.getDes().equals("藏宝洞")){
			System.out.println("恭喜你找到了宝藏！游戏结束！");
			System.out.println("你可以重头开始！");			
		}
		else if(currentRoom.getDes().equals("城堡外")){
			System.out.println("你现在在城堡外");
			System.out.println("输入“go east”进入城堡！");
			num =2;
		}
    	else{
    	   System.out.println("你进入了" + currentRoom.getDes());
           System.out.print("出口有: ");
           System.out.print(currentRoom.getExitDisc());
           System.out.println();
           num = 1;
    	}
		return num;
	}
	
	
}
