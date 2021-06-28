# 简介
Google的Jetpack示例项目[Sunflower](https://github.com/android/sunflower)还在不断地迭代改进中，这个项目可以结合官方文档作为一个非常充分的Jetpack库的示例。在这个项目中还是有一些没有改掉的legacy code 导致没看明白，同时说有些库的功能只有自己动手实践才能真正了解。基于上述目的，在阔别了Android开发一段时间之后，实现的MySunflower作为Sunflower的子集，让我重新了解一下目前Android开发的生态--同时也是一条“复健之路”。
# 使用
本项目和Sunflower一样都使用了[Unsplash api](https://unsplash.com/documentation),为了隐私安全，项目隐去了存有ACCESS_KEY，需要使用项目的话可以
自行创建一个Unsplash 账号获取ACESS_KEY。然后将此行加入gradle.properties的最后一行
````
unsplash_access_key = <your access key>
````

# Jetpack Library
- [ ] Room
- [ ] WorkManager
- [x] LifeCycle
- [x] Navigation
- [x] Hilt
- [x] Databinding 
