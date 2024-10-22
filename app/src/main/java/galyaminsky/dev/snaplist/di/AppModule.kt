package galyaminsky.dev.snaplist.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import galyaminsky.dev.snaplist.data.AddItemRepoImpl
import galyaminsky.dev.snaplist.data.AddItemRepository
import galyaminsky.dev.snaplist.data.MainDb
import galyaminsky.dev.snaplist.data.NoteRepoImpl
import galyaminsky.dev.snaplist.data.NoteRepository
import galyaminsky.dev.snaplist.data.ShoppingListRepoImpl
import galyaminsky.dev.snaplist.data.ShoppingListRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMainDb(app: Application): MainDb {
        return Room.databaseBuilder(
            app,
            MainDb::class.java,
            "shop_list_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideShopRepo(db: MainDb): ShoppingListRepository {
        return ShoppingListRepoImpl(db.shoppingListDao)
    }

    @Provides
    @Singleton
    fun provideAddItemRepo(db: MainDb): AddItemRepository {
        return AddItemRepoImpl(db.addItemDao)
    }

    @Provides
    @Singleton
    fun provideNoteRepo(db: MainDb): NoteRepository {
        return NoteRepoImpl(db.noteDao)
    }
}