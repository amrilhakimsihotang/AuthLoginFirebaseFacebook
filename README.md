# AuthLoginFirebaseFacebook
Firebase Authentication with FB


1. buka project android, dan masuk ke menu tools->firebase
2. pilih analytics-> Get started with google Analytics
3. connect to firebase->pilih Build
4. pilih selanjutnya connect to firebase 
5. akan muncul console firebase google.
6. lalu isikan nama project, dan continue terus
7. pilih default for firebase-> create project
8. pilih connect agar bisa connect ke android

9. pilih kembali point 1, dan klik authentication using facebook login(kotlin)

10. Add the firebase Authentication SDK to your App
11. Accept Changes



untuk setting di facebook developer
1. https://developers.facebook.com/apps/
2. pilih create App
3. saya pilih none, dan klik continue
4. isikan nama app Display Name
5.pilih settings->basic
6. copy AppID dan App Secret ke firebase
7. pada menu Facebook Login, klik set Up
8. Pilih Android, dan klik next
9. copy ke gradle -> implementation 'com.facebook.android:facebook-android-sdk:[5,6)'
jika perlu lakukan update yak

10. klik next dan masukkan nama package dan default activity class name
11. klik continue
12. pada posisi tab windows, klik openssl-for-windows
13. pilih openssl-0.9.8k_X64.zip  dan download serta ekstrak
14. masuk ke folder C:\Program Files\Java\jdk1.8.0_291
via cmd,
15. setelah itu copykan dari developer facebook
      
keytool -exportcert -alias androiddebugkey -keystore "C:\Users\USERNAME\.android\debug.keystore" | "D:\data\project_android\AuthLoginFirebaseFacebook\openssl-0.9.8k_X64\bin\openssl" sha1 -binary | "D:\data\project_android\AuthLoginFirebaseFacebook\openssl-0.9.8k_X64\bin\openssl" base64
      

16. copykan hasil hash yang di dapat paka developer facebook key hashes, lalu simpan

-->lalu koding di android


untuk setting di firebase

1. pilih Authentication
2. sign-in method
3. pilih facebook, dan enable
4. paste App ID dan App Secret yg di dapat dari FB, lalu save
