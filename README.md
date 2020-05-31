# Merge Adapter

## Description

Application réalisé dans le but d'illustrer la nouvelle fonctionnalité de RecyclerView : MergeAdapter disponible dans la librairie `androidx.recyclerview:recyclerview:1.2.0-alpha02`

Elle permet de combiner séquentiellement plusieurs adapteurs pour les afficher dans un seul RecyclerView. Cela vous permet de mieux encapsuler vos adapteurs plutôt que d'avoir à combiner de nombreuses sources de données en un seul adapteur, en les gardant concentrées et réutilisables.


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

[Lien de l'article](https://stephenbellanger.wordpress.com/2020/05/31/merge-adapter/)


## Screenshots

![GitHub Logo](/screenshots/device-2020-05-31-174917.png)

## Auteur

[@StephenBellanger](https://stephenbellanger.wordpress.com) 

## License

MergeAdapter is available under the MIT license. See the  [LICENSE](https://github.com/stephenbellanger/ProBill/blob/master/LICENSE)  file for more info.
