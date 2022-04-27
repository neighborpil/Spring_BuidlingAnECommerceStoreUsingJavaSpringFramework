# Spring_BuidlingAnECommerceStoreUsingJavaSpringFramework
hands on codes
-----------------
##Libraries
- JQuery: 3.5.1
- Pooper: 1.16.1
- Bootstrap: 4.6.1
-------------------------
### 파일 저장시 webapps폴더 밖에 파일을 두는 법
 - 톰캣 server.xml에서 host 영역 안에 파일 저장할 리얼 경로와 접근할 웹 경로를 매핑시켜 준다.
```
<Context docBase="C:\codes\Utils\apache-tomcat-9.0.40\images"  path="/images" />
```
 - 이미지 태그의 src에 경로를 <c:url value='/images/파일명.png' />로 해준다

```

      <Host name="localhost"  appBase="webapps"
            unpackWARs="true" autoDeploy="true">

	<Context docBase="C:\codes\Utils\apache-tomcat-9.0.40\images"  path="/images" />
        <!-- SingleSignOn valve, share authentication between web applications
             Documentation at: /docs/config/valve.html -->
        <!--
        <Valve className="org.apache.catalina.authenticator.SingleSignOn" />
        -->

        <!-- Access log processes all example.
             Documentation at: /docs/config/valve.html
             Note: The pattern used is equivalent to using pattern="common" -->
        <Valve className="org.apache.catalina.valves.AccessLogValve" directory="logs"
               prefix="localhost_access_log" suffix=".txt"
               pattern="%h %l %u %t &quot;%r&quot; %s %b" />

      </Host>
```

 - 절대 경로에 파일 저장하기

```
@PostMapping("/admin/productInventory/addProduct")
    public String addProductPost(@ModelAttribute("product") Product product, HttpServletRequest request) {
        productDao.addProduct(product);

        MultipartFile productImage = product.getProductImage();

        // 리얼서버에서 webapps 폴더 외에 저장하는 법(catarina.home/images/)
        String rootPath = System.getProperty("catalina.home");
        File dir = new File(rootPath + File.separator + "images");
        if (!dir.exists())
            dir.mkdirs();

        // Create the file on server
        String path = dir.getAbsolutePath() + File.separator + product.getProductId() + ".png";

        // 실제 파일 저장할 때에 파일 확장자 설정법
//      java.util.Date date= new java.util.Date();
//      String path = dir.getAbsolutePath() + File.separator
//                + (new Timestamp(date.getTime())).toString().replace(":", "").toString()
//                .replace(".", ".").toString()
//                .replace(" ","").toString()
//                .replace("-","").toString()+".png";

        // 개발서버에 저장하는 법
//      String rootDirectory = request.getSession().getServletContext().getRealPath("/");
//      path = Paths.get(rootDirectory + "\\WEB-IN\\resources\\images\\" + product.getProductId() + ".png");

        if (productImage != null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(new File(path.toString()));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Product image saving failed", e);
            }
        }

        return "redirect:/admin/productInventory";
    }
```
--------------------------------------
### 개발할 때에 output 폴더를 바꿔준다
 - 이미지를 저장할 경로는 /resources/images이다(폴더 사전 생성 필요)
 - 이미지를 저장할 때에 out폴더가 아닌 개발소스내 webapps폴더 내에 다이렉트로 넣어주기 위함이다

```
C:\codes\GitRepository\Spring_BuidlingAnECommerceStoreUsingJavaSpringFramework\Section02\MusicStore\out\artifacts\MusicStore_war_exploded
```
↓
```
C:\codes\GitRepository\Spring_BuidlingAnECommerceStoreUsingJavaSpringFramework\Section02\MusicStore\src\main\webapp
```
