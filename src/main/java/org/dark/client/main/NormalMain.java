package org.dark.client.main;

import org.dark.client.command.HelloCommand;

public class NormalMain {

	public static void main(String[] args) {
		/**
		 * 通過封裝命令，我們現在僅用這樣幾行就可以實現HttpClientMain中main方法的近十行的功能
		 * 其實代碼量並沒有減少，反而增多了。但是這樣寫的好處在於，責任的分離
		 * 同時，Hystrix以線程的形式幫我們實現了HttpClientMain中的main方法的功能。
		 */
		HelloCommand command = null;
		String result = null;
		
		try {
			command = new HelloCommand();
			result = command.execute();
			System.out.println(result );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
