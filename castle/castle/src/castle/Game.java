package castle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Game {
	private int blood =3;
	private int power = 200;
    private Room currentRoom;
    private HashMap<String,Handler> handlers = new HashMap<String,Handler>();
    private ArrayList<Room> rooms = new ArrayList<Room>();    
    public Game() 
    {
    	handlers.put("bye", new HandlerBye(this));
    	handlers.put("help", new HandlerHelp(this));
    	handlers.put("go", new HandlerGo(this));
 //   	handlers.put("show",new HandlerShow(this));
        createRooms();
    }

    private void createRooms()
    {
    	Room [] r =new Room[14];
//    	ArrayList<Room> rooms =new ArrayList<>();
//        Room outside, lobby, pub, study, bedroom,treasure;
      
        //	制造房间
        r[0] = new Room("城堡外");
        r[1] = new Room("大厅");
        r[2] = new Room("小酒吧");
        r[3] = new Room("地下室");
        r[4] = new Room("书房");
        r[5] = new Room("花园");
        r[6] = new Room("主卧");
        r[7] = new Room("次卧");
        r[8] = new Room("主卧阳台");
        r[9] = new Room("次卧阳台");
        r[10] = new Room("后山");
        r[11] = new Room("悬崖");
        r[12] = new Room("老虎洞");
        r[13] = new Room("藏宝洞");
        
        //	初始化房间的出口
        r[0].setExit("east",r[1]);      
        r[1].setExit("east",r[4]);r[1].setExit("north",r[2]);r[1].setExit("south",r[6]);r[1].setExit("west", r[0]);
        r[2].setExit("south",r[1]);r[2].setExit("east",r[3]);
        r[3].setExit("west",r[2]);
        r[4].setExit("east",r[5]);r[4].setExit("west",r[1]);
        r[5].setExit("east",r[10]);r[5].setExit("west",r[4]);
        r[6].setExit("north",r[1]);r[6].setExit("south",r[8]);r[6].setExit("west",r[7]);
        r[7].setExit("east",r[6]);r[7].setExit("south",r[9]);
        r[8].setExit("north",r[1]);r[6].setExit("west",r[7]);
        r[9].setExit("north",r[7]);r[9].setExit("east",r[8]);
        r[10].setExit("north",r[13]);r[10].setExit("east",r[12]);r[10].setExit("south",r[11]);r[10].setExit("west",r[5]);
        r[11].setExit("north",r[1]);
        r[12].setExit("west",r[10]);
//        r[13].setExit("south",r[10]); 
//		将Room对象放到 Arraylist rooms        
        for(Room an : r){
        	rooms.add(an);
        }
                   
        currentRoom = r[0];  //	从城堡门外开始
//        return (Room[])rooms.toArray();
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("这是一个无聊的寻宝游戏！");
        System.out.println("你将进入一座城堡，并找到城堡中的宝藏。");
        System.out.println("每进入一个房间，你有可能触发随机传送到其它房间的传送门。");
        System.out.println("房间中可能会有怪物存在,打败它能增加1点HP,反之减少1点HP");
        System.out.println("当HP为0时，游戏结束。");
        System.out.println("如果需要帮助，请输入 'help' 。");
        System.out.println();
        showPrompt();
    }

    // 以下为用户命令

    public void goRoom(String direction) 
    {
        Room nextRoom = currentRoom.getExit(direction);        

        if (nextRoom == null) {
            System.out.println("那里没有门！");
        }
        else {
            currentRoom = nextRoom;
            //判断是否进行传送
            if(currentRoom.portal()){
            	currentRoom = rooms.get((int)Math.random()*(rooms.size()-5)+1);
            	System.out.println("你触发了传送门");
            }
            showPrompt();
            
        }
    }
    
    public void filght(){
    	
    	if(Math.random()*10>5.0){
    		System.out.println("碰到怪物，进入战斗！" );
    		monster mons = new monster(power);
    		System.out.println("你的战斗力为"+power );
    		System.out.println("怪物的战斗力为"+mons.getPower() );
        	if(this.power > mons.getPower()){        		
        		System.out.println("你找败了怪物,获得1HP" );
        		power =(int)(power*1.2);
        		blood++;
        		System.out.println("当前血量为"+blood );
        		System.out.println();
        	}else{
        		System.out.println("不敌败走，失去1HP" );
        		blood--;
        		System.out.println("当前血量为"+blood );
        		System.out.println();
        		currentRoom = rooms.get(rooms.indexOf(currentRoom)-1);        		
        		showPrompt();
        	}
        	
    		
    	}

    }
    public void showPrompt(){
    	HandlerShow handler = new HandlerShow(this);
    	int a = handler.show(currentRoom);
    	if(a == 1){
    		filght();
    	}else if(a == 0){
    		currentRoom = rooms.get(0);
    		handler.show(currentRoom);
    	}
    }
    
    public void play(){
    	Scanner in = new Scanner(System.in);
        while ( true ) {
        	if(blood <=0){
        		System.out.println("胜败乃兵家常事，英雄请重新来过");
        		break;
        	}        		
    		String line = in.nextLine();
    		String[] words = line.split(" ");
    		Handler handler = handlers.get(words[0]);
    		String value = "";
    		if(words.length>1)
    			value = words[1];
    		if(handler!= null){
    			handler.doCmd(value);
    			if(handler.isBye())
    				break;
    		}
//    		if ( words[0].equals("help") ) {
//    			printHelp();
//    		} else if (words[0].equals("go") ) {
//    			goRoom(words[1]);
//    		} else if ( words[0].equals("bye") ) {
//    			break;
//    		}
        }
        in.close();
    }
	
	public static void main(String[] args) {		
		Game game = new Game();
		game.printWelcome();
		game.play();        
        System.out.println("感谢您的光临。再见！");
        
	}

}
