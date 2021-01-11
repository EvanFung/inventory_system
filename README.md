第一天：  
因為沒有接觸過warehouse inventory system的緣故。當初接到這個project，我不知道怎麼下手好，所以我接到這個項目第一個要做的事情就是調查好，倉庫系統最主要和的作用是什麼。 倉庫系統的最主要作用是，管理物理倉庫裡面庫存的數量。簡單來說，因為倉庫面積很大，裡面的商品很多，所以要有一套系統來管理庫存的數量。
接下來我要分析的就是用這個系統最主要的人是什麼人，即係要有一個Use case去分析具體要有什麼功能去實現。一般來說，倉庫的系統，有採購入庫、產品出庫和倉庫間的調拔。而這個項目最主要要的功能就是倉庫間的調拔，因為稍微大一點的電商都會有很多個倉庫分配在全港各地、商品也是有規律的分配一定商品數量在全港各地，當User落單的時候，希望以離用戶最近的倉庫發貨，這樣速度快距離短。
經過在網上查閱資料得知，完成調拔有三個步驟，發起調拔申請、調拔出庫、調拔入庫，設計數據庫時也應該要朝著這個方向去考慮。發起調拔的時候，有一個難點就是需要在倉庫裡面鎖定Product的數量，因為如果不進行鎖定的話極端情況下比如A倉的這個product可能突然就賣掉了950件，這時候倉庫只剩下了50個，倉庫就沒有辦法進行100個商品的調撥，會影響商家的整體統籌安排。
還有一個問題就是在貨物的調動過程中，貨物的狀態也應該要得到考慮，比如話貨物失蹤了。  
第一天主要就是設計數據庫、架設Project的環境、Use case的分析，還有學習Spring和Java的知識。

  

第二天：
正式開始寫code，因為現在上班最主要還是做前端，所以對Spring 和Java 的Backend的寫法不是很熟，基本上是沒什麼基礎的情況下，邊查閱資料邊寫這個Project，所以寫得不好請見諒。  
第二天完成了，create product, import product from csv, import stock information from csv, 貨物的調動的API，各種 java model entity的添加和查詢。可是在import stock information from CSV這裡的business logic 出了點小問題，導致添加貨物進倉的時候，存貨table（inventory table）和stock table的數據不一致，這個問題有待解決。還有用React寫了前端，2 個頁面，Product page和product details page。
第二天來說可能大概寫了2000 行左右。不過還有很多功能未得到實現，只是在backend API 層面實現了（用PostMan測試過沒問題），具體的frontend還沒有做好。  
第三天要上班還有開會討論一些事情，應該沒有時間去做這個project，如果不幸做不完，請面試官多多見諒！畢竟剛剛畢業還沒有由頭開始做過有關Java的project，在做的過程上遇到很多問題，總的來說就是只學了2 天Java的Framework，之前一直在寫Nodejs和Nosql。
很多關係型數據庫東西在概念上熟悉，在寫代碼上還不是很熟悉。在處理Many To Many， One To Many、foreign key等等的數據庫問題都遇到了很多困難，可是大部分都一一解決了。  
第二天難點： 處理庫存數據的不一致⋯⋯
  
第三天：
因為今日要開會和討論新項目的事情，所以沒有時間做這個項目，不過感恩有這個項目給我練一下手，以後再繼續學習一下有關Java相關的技術，希望會寫得更快。這個項目其實只用了一天半的時間去寫，因為上班的緣故，沒有太多時間去完成，很多功能上還沒有實現到，非常可惜。由於時間關係，沒能完成這個項目，請見諒。
  
用到的技術：React、Spring Boot、Spring data JPA、MySQL、Java version 11