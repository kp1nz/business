## 电商项目服务端开发
 
 ### 模块一、用户模块
 #### 1，功能介绍
    登录
    用户名验证
    注册
    忘记密码
    提交问题答案
    重置密码
    获取用户信息
    更新用户信息
    退出登录
 #### 2，学习目标
     横向越权、纵向越权安全漏洞
     横向越权：攻击者尝试访问与他拥有相同权限的用户的资源
     纵向越权：低级别攻击者尝试访问高级别用户的资源
     MD5明文加密及增加salt值
     Guava缓存的使用
     高服用服务响应对象的设计思想及抽象封装
 #### 3，服务端接口返回前端的统一对象
         class ServerResponse<T>{
           int status;//接口返回状态码
           T  data;//封装了接口的返回数据
           String msg;//封装错误信息
          }
 #### 4，业务逻辑
 ##### 4.1登录功能
         step1:参数非空校验
         step2:校验用户名是否存在
         step3:根据用户名和密码查询用户
         step4:返回结果
 ##### 4.2注册功能
          step1:参数非空校验
          step2:校验用户名是否存在
          step3:校验邮箱是否存在
          step4:调用Dao接口插入用户信息
          step5:返回结果
 ##### 4.3忘记密码之修改密码功能
 ###### 4.3.1 根据username查询密保问题
         step1:参数非空校验
         step2:校验username是否存在
         step3:根据username查询密保问题
         step4:返回数据  
 ###### 4.3.2 提交问题答案
         step1:参数非空校验
         step2:校验答案是否正确
         step3:为防止横向越权，服务端生成forgetToken保存，并将其返回给客户端
         step4:返回结果
 ###### 4.3.3 重置密码   
         step1:参数非空校验
         step2:校验token是否有效
         step3:修改密码
         step4:返回结果
 ### 迭代开发-线上部署
        step1:在阿里云服务器上建库、建表
        step2:修改代码中数据库的连接参数
        step3:项目打成war包
        step4:将war包上传到阿里云服务器的tomcat/webapps
        step5:访问测试  
 ### 模块二、类别模块
 #### 1，功能介绍
        获取节点
        增加节点
        修改名称
        获取分类
        递归子节点ID
  #### 2，学习目标
        如何设计及封装无限层级的树状数据结构
        递归算法的设计思想
        如何处理复杂对象重排
        重写hashcode和equals的注意事项
  
  #### 3,业务逻辑
  ##### 3.1 获取节点
         step1:判断管理员权限
         step2:参数非空校验
         step3:查询子节点
         step4:返回结果   
         
  ##### 3.2 增加节点
         step1:判断管理员权限
         step2:参数非空校验
         step3:添加节点
         step4:返回结果 
          
   ##### 3.3 修改名称
            step1:判断管理员权限
            step2:参数非空校验
            step3:修改节点名称
            step4:返回结果  
                
  ##### 3.4 递归子节点ID
            step1:判断管理员权限
            step2:参数非空校验
            step3:递归查询子节点
            step4:返回结果 
                 
  ###  模块三、 商品模块
  ####  1，功能介绍
  ##### 前台功能
                产品搜索          
                动态排序列表
                商品详情 
                
  ##### 后台功能
                商品列表
                商品搜索
                图片上传
                富文本上传
                商品详情
                商品上下架
                增加商品    
                更新商品
                
   #### 2，学习目标
   
   <li>FTP服务的对接</li>
   <li> SpringMVC文件上传</li>
   <li>流读取Properties配置文件</li>
   <li>抽象POJO、BO、VO对象之间的转换关系及解决思路</li>
   <li>joda-time快速入门</li>
   <li>静态块</li>
   <li>Mybatis-PageHelper高效准确地分页及动态排序</li>
   <li>Mybatis对List遍历的实现方法</li>
   <li>Mybatis对Where语句动态拼接</li>
   <li>POJO、BO business object、VO view object</li>
   <li>POJO、VO</li>
    
  #### 3，业务逻辑
  ##### 3.1 后台-添加或更新商品
         step1:判断管理员权限
         step2:参数非空校验
         step3:设置商品的主图
         step4：添加或更新商品
         step5：返回结果
   ##### 3.2 后台-商品上下架
         step1:判断管理员权限
         step2:参数非空校验
         step3:更新商品状态
         step4：返回结果
   ##### 3.3 后台-查看商品详细
         step1:判断管理员权限
         step2:参数非空校验
         step3:根据商品id查询商品信息Product
         step4：将Product转成ProductDetailVO
         step5：返回结果 
   ##### 3.4 后台-分页查看商品列表
            step1:判断管理员权限
            step2:参数非空校验
            step3:集成mybatis分页插件
            step4:查询所有商品
            step5：将List<Product>转成List<ProductListVO>
            step6：返回结果          
   ##### 3.5 后台-商品搜索
            step1:判断管理员权限
            step2:集成mybatis分页插件
            step3:按照商品id或名称模糊查询
            step4:将List<Product>转成List<ProductListVO>
            step5:返回结果   
            
   ##### 3.6 后台-图片上传
            step1:图片重命名
            step2:图片保存到应用服务器
            step3:上传到图片服务器
            step4:将应用服务器的图片删除
            step5:返回结果  
  ##### 3.7 前台-商品详情
            step1:参数校验
            step2:查询商品
            step3:校验商品状态
            step4:商品转成VO
            step5:返回结果          
  ##### 3.7 前台-搜索商品并动态排序
            step1:参数校验
            step2:根据类别和关键字查询
            step3:集成分页插件
            step4:转成VO
            step5:返回结果           

             
             
             
                