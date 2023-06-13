
Feature: N11 AndroidApp Test Scenarios

  Scenario: TC0001 Successful LogIn And LogOut
    Given N11 AndroidApp APK Open
    When Click On Login Icon On Homepage
    Then Click On SignIn Button
    And Send Valid Email "bW1vdmVzZW4xQGdtYWlsLmNvbQ=="
    And Send Valid Password "QXR3YTE5ODU"
    And Click On Login Button
    And Click On Login Icon On Homepage
    And Click On Settings Icon On Account Page To Navigate LogOut Page
    And Click On LogOut
    And Click On Yes LogOut on PopUp


  Scenario: TC0002 Add A Product To Cart Them Delete Cart And LogOut
    Given N11 AndroidApp APK Open
    When Click On Login Icon On Homepage
    Then Click On SignIn Button
    And Send Valid Email "bW1vdmVzZW4xQGdtYWlsLmNvbQ=="
    And Send Valid Password "QXR3YTE5ODU"
    And Click On Login Button
    And Click On Homepage Icon
    And Send Product Name "Amator Denizcilikte Acil Durum Seyri"
    And Click On Product
    And Click On Add Product Button
    And Click On Delete Product Icon Delete From Cart
    And Check Welcoming Text "Sepetiniz Boş Görünüyor"
    And Click On Login Icon On Homepage
    And Click On Settings Icon On Account Page To Navigate LogOut Page
    And Click On LogOut
    And Click On Yes LogOut on PopUp
    And Check "Üye Ol / Giriş Yap" Whether LogOut Complete



