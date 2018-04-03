# kan2
# Kan Bağışı Uygulaması

## Kullanılan Teknolojiler

Öncelikle bu proje acı deneyimlerle doludur:). Uygulamada **JPA**, **JSF**, **MAVEN** ve **Primefaces** kullanıldı.
IDE olarak **Netbeans 8.0** ı seçtim, çünkü daha önce desktop uygulaması geliştiriken kullanmıştım ve biraz 
kullanımı kolay geldi, Eclipse e göre. Uygulamada veritabanı işlemlerini, Java sınıflarında kolayca gerçekleştirebilmek için 
**JPA** teknolojisini kullandım. Bunun yanında web sitesindeki formlarımı **JSF** teknolojisini kullanarak hallettim.
Çalışıyorum ve vakit ayırmakta güçlük çektiğim için; son kullanıcıya yönelik arayüz kısımlarını, **Primefaces** ile gerçekleştirdim.
Bunlar haricinde web server olarak **Tomcat 8** i kullandım. Sebebi ise bi kaç öneri almıştım daha önce. Veritabanı olarak mysql kullandım
çünkü daha önce bu veritabanı ile çalışmıştım. Veritabanı yönetim sistemi olarak ise **PhpMyAdmin** kullandım. Projenin IDE bağlılığını
ortadan kaldırmak için ise **MAVEN** teknolojisi kullandım.


## Kurulum

Öncelikle projenin kullanılan Ide ortamına import edilmesi gerekiyor. Bunun yanında bilgisayarınızda veritabanının bulunması gerekiyor.
Veritabanı dump dosyası **kanbagis** adı ile proje dosyasında mevcut, bunu direkt olarak veritabanı ortamınıza import edebilirsiniz.
Bunlara ek olarak tabikide ide ortamınıza göre özelleştirdiğiniz ve kurulumunu yaptığınız web server e ihtiyaç var. Tomcat 8.0 tavsiye
edilir.  Tüm bunları yaptıktan sonra **src/main/resources/META-INF/** içerisindeki  **persistance.xml** dosyası içerisinde kullandığınız,
veritabanı konfigürasyon ayarlarınızı yapmanız gerekmekte. Bu işlemleri gerçekleştidikten sonra bir de **pom.xml** dosyası içerisinde
belirtilen gerekliliklerin kütüphaneye eklenip eklenmediğini kontrol edebilirsiniz.

## Kullanım

Son kullanıcı uygulamayı açtığında ilk olarak **login** sayfası ile karşılaşacak ve burda bağışçı **üye ol** butonu ile ilgili sayfadaki formu
doldurup sisteme kayıt olabilecek. Sonrasında ise **kullanıcı ismi** ve **şifresini** girerek sisteme giriş yapabilecek. Burdan sonraki sayfa
**kullanıcı sayfası**. Bu sayfada kullanıcı **bilgileri güncelle** butonu ile açılan pop up ta ki ilgili bilgi kısımlarını doldurarak,
sistemdeki bilgilerini güncelleyebilirler. Bunun haricinde kullanıcılar **hesabı sil** butonu ile kayıtlarını silebilirler. Fakat bu
kayıtlar veritbanından silinmez. Bunun yerine veritabanındaki kullanıcı tablosundaki active_deactive değeri değişir. Bu kullanıcıların
sisteme giriş yapmamalarını ise; bu değerin kontrolü ile yapıyorum. Kullanıcılar parolalarını unuttukları zaman **login** sayfasındaki 
**şifremi unuttum** butonu ile ilgili sayfaya yönlendirilirler. Burda kullanıcı isimlerini doldurduktan sonra, sistemde kayıtlı olan mail
adreslerine kullanıcı şifresi mesaj olarak gider.
Kan ihtiyacı olanlar ise **login** sayfasında **acil kan** butonuna tıklayabilirler ve açılan pop up taki formu doldurarak, aranan 
kriterlere uygun bağışçıları; açılan sayfada görebilirler. Bu kısımda ise kullanıcılar, görüntülenen bağışçıların telefon gibi
bilgilerini görüntüleyebilmek için **bilgileri görüntüle** butonuna tıklayıp bilgilerin popupta görüntülenmesi gerekiyor fakat uygulamanın 
bu kısmında bir sorun var. Bu sorunun **Controller** sınıfımda kullandığım **annotions** ile ilgili olduğunu düşünüyorum çünkü
şeçilen kullanıcıyı java sınıfındaki bir nesneye atmakta problem yaşıyorum ve :dialog **oncomplete** olmadığı için görüntülenmiyor.




## Hatalar, Olsa İyi Olurlar

-İlk olarak son kullanıcıya yönelik görüntülenen form sayfalarına CSS eklentilerinin eklenmesi iyi olur.
-Kullanıcılara mail atmak için **javax.mail** kullandım fakat stabil bir eklenti olmadı, ara sıra hata verebiliyor, sebebinin web server
dan kaynaklandığını düşünüyorum. Bunun incelenmesi ve stabil hale getirilmesi gerekiyor.
-Kullanıcılardan sadece il bilgisini alıyorum. Bunun yanında kullanıcıların açık adreslerinin kaydedildiği bir alan olması daha iyi olur.
-Kullanıcılar hesaplarını sildikleri zaman active-deactive değerini 2 yapıyorum ve girişte bunun kontrolünü sağlıyorum, bunun yerine
başka bir tabloda geçerli id numaraları ile tutabilirim.

Bunlar projeyi bitirdikten sonra inceleyip görebildiklerim bunlarında giderilmesi programı daha iyiy yapacaktır ve diğer versiyonlarda bunlara
dikkat edilecek.

