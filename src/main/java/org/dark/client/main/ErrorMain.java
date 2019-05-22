package org.dark.client.main;

import org.dark.client.command.ErrorHelloCommand;

public class ErrorMain {

	public static void main(String[] args) {
		/**
		 * 與NormalMain類似
		 * 當我們沒有在ErrorHelloCommand重寫getFallback方法的時候，
		 * 這裡執行後看到的效果應該是超時的報錯，這就是我們要的效果
		 * 
		 * 但是當我們重寫了getFallback方法，就會看到回退方法中打出的信息了。
		 */
		ErrorHelloCommand command = null;
		String result = null;
		
		try {
			command = new ErrorHelloCommand();
			result = command.execute();
			System.out.println(result );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
