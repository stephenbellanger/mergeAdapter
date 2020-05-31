# Merge Adapter

## Description

Application réalisé dans le but d'illustrer la nouvelle fonctionnalité de RecyclerView : MergeAdapter

```kotlin
override fun initRecyclerView() {
    recycler_view.apply {
         layoutManager = LinearLayoutManager(context)
         adapter = MergeAdapter(
             headerAdapter,
             mainDataAdapter,
             footerAdapter
         )
     }
}
```

[Lien de la documentation](https://developer.android.com/reference/androidx/recyclerview/widget/MergeAdapter)

[Lien de l'article](https://developer.android.com/reference/androidx/recyclerview/widget/MergeAdapter)


## Screenshots

![GitHub Logo](/screenshots/device-2020-05-31-161618.png)
![GitHub Logo](/screenshots/device-2020-05-31-161639.png)

## Auteur

[@StephenBellanger](https://stephenbellanger.wordpress.com) 

## License

MergeAdapter is available under the MIT license. See the  [LICENSE](https://github.com/stephenbellanger/ProBill/blob/master/LICENSE)  file for more info.
