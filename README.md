# Matchmaker

这是一款专为微信小程序开发的插件，目前可在 IntelliJ IDEA 中使用。它可以帮你完成重复机械无趣麻烦的绑定方法的过程，自动的将需要新建的方法注入到 js 文件中去。

**PS：其实我本来的目的是做一个能在 WebStorm 里面使用的插件的，但是没想到做出来之后反而没办法在 WebStorm 用，只能在 IntelliJ IDEA 里用，如果有哥们儿知道怎么搞的话请告知一下，感激不尽。**

# GIF展示

这是在 IntelliJ IDEA 中插件的展示效果

![在 IntelliJ IDEA 中的展示](https://raw.githubusercontent.com/lypeer/Matchmaker/master/gif/plugin.gif)

# 装载插件

不知道为什么，我把插件上传到 JetBrains Plugins Repository 之后它就一直处于 Wait for approve 的阶段，截止目前都是如此，也就是说现在要用的话就只能下载 jar 包然后装载本地插件了，**[jar 包在这里](https://github.com/lypeer/Matchmaker/blob/master/Matchmaker.jar?raw=true)。**

# 作用

我们都知道，在开发微信小程序的时候，*wxml* 和 *js* 之间如果要有事件响应的话，是要先在 *wxml* 用 `bind***/catch***` 标签绑定一个方法，然后在 *js* 里面一个一个去把 *wxml* 里面定义的方法写出来的。

这个写空方法的过程其实很无聊，就跟 *Android* 里面的 *findViewById* 一样。想一下如果一个比较复杂的页面有十几个甚至几十个绑定的方法，那写起来多尴尬。这个插件就是用来把 *wxml* 里面声明的方法直接注入到 *js* 里面的，自动生成代码，让我们可以把时间和精力花在更有技术含量的地方。

# 用法

用法非常的简单，直接在 JS 代码点击右键，然后 Generate -> Match make 就可以了。当然你可以为这个功能设置一个快捷键，让它更加方便。

# 开源协议

```java
  Copyright 2014-2016 lypeer.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
