springboot项目访问html文件
   a) ：application.properties中配置spring.mvc.view.prefix=/
   b) ：html文件放入/resource/resources/ 目录中
   c) ：maven添加resource标签，这个可选，classes目录中如不生成对应html文件则加入
         <resource>
             <directory>src/main/resources</directory>
             <includes>
                 <include>**/*</include>
             </includes>
         </resource>