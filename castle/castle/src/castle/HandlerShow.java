package castle;

public class HandlerShow extends Handler {

	public HandlerShow(Game game) {
		super(game);	
	}

	
	public int show(Room currentRoom) {
		int num = 0;
    	//���벻ͬ����˵��ͬ�Ļ�
    	if(currentRoom.getDes().equals("����")){
			System.out.println("����������£������¿�ʼ��");			
		}
		else if(currentRoom.getDes().equals("�ϻ���")){
			System.out.println("����������壬�����¿�ʼ��");			
		}
		else if(currentRoom.getDes().equals("�ر���")){
			System.out.println("��ϲ���ҵ��˱��أ���Ϸ������");
			System.out.println("�������ͷ��ʼ��");			
		}
		else if(currentRoom.getDes().equals("�Ǳ���")){
			System.out.println("�������ڳǱ���");
			System.out.println("���롰go east������Ǳ���");
			num =2;
		}
    	else{
    	   System.out.println("�������" + currentRoom.getDes());
           System.out.print("������: ");
           System.out.print(currentRoom.getExitDisc());
           System.out.println();
           num = 1;
    	}
		return num;
	}
	
	
}
