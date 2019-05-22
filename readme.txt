hystrix的實例工程
調用了本工程的server包中提供的服務
調用客戶端在本工程的client包中
當first-hy-server中的某個服務提供接口的響應時間超過一定時長
則hystrix會自動調用回退方法。

對於Hystrix的執行，有四種方法
1：toObservable		可以觀察命令執行的過程，並且將執行的信息傳遞給訂閱者。
2：observe			通過調用第一個方法，獲取了一個原始的可觀察的對象，在使用一個replySubject作為原始的toObservable的訂閱者。
3：queue			也是通過調用toObservable，獲得一個原始的可觀察的對象，進而獲取此對象的blockingObservable的實例
					最後獲得一個toFuture實例
4：execute			通過調用queue，返回一個執行結果。
前三個都是異步，最後一個是同步的

第一個方法toObservable被調用後不會立刻執行，只有當可觀察的實例被訂閱之後，才會真正執行。類似於觀察者模式或監聽器模式
