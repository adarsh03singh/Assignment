package  com.example.sonetassignment.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.sonetassignment.model.countryModelList.CountryModel
import com.example.sonetassignment.model.regionModelList.RegionModel

// DAO CAN BE ABSTRACT CLASS OR INTERFACE
interface BaseDao<T> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(obj: T)
}


@Dao
abstract class CountryListDao: BaseDao<List<CountryModel>> {
    @Query("DELETE FROM country_List")
    abstract fun delete()

    @Query("SELECT * from country_List")
    @JvmSuppressWildcards
    abstract fun getAllData(): LiveData<List<CountryModel>>
}

@Dao
interface RegionDao: BaseDao<List<RegionModel>> {

    @Query("DELETE FROM region_List")
    fun delete()

    @Query("SELECT * from region_List")
    @JvmSuppressWildcards
    fun getAllDetailData(): LiveData<List<RegionModel>>

}