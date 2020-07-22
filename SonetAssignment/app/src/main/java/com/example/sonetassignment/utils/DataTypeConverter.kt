package com.example.sonetassignment.utils

import androidx.room.TypeConverter
import com.example.sonetassignment.model.countryModelList.*
import com.example.sonetassignment.model.countryModelList.Currency
import com.example.sonetassignment.model.regionModelList.RegionModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*

class CountryTypeConverters {

    @TypeConverter
    fun stringToSomeObjectList(data: String?):  List<Currency?> {
        if (data == null) {
            return Collections.emptyList()
        }

        val listType = object : TypeToken<List<Currency?>>() {}.type
        return Gson().fromJson(data, listType)
    }
    @TypeConverter
    fun someObjectListToString(someObjects: List<Currency?>): String {
        return Gson().toJson(someObjects)
    }

    @TypeConverter
    fun languageToSomeObjectList(data: String?):  List<Language?>? {
        if (data == null) {
            return Collections.emptyList()
        }

        val listType = object : TypeToken<List<Language?>?>() {}.type
        return Gson().fromJson(data, listType)
    }

    @TypeConverter
    fun languageBlocToString(someObjects: List<Language?>?): String {
        return Gson().toJson(someObjects)
    }

    @TypeConverter
    fun regionalBlocToSomeObjectList(data: String?):  List<RegionalBloc?>? {
        if (data == null) {
            return Collections.emptyList()
        }

        val listType = object : TypeToken<List<RegionalBloc?>?>() {}.type
        return Gson().fromJson(data, listType)
    }



    @TypeConverter
    fun stringToSome(data: String?):  List<String?>? {
        if (data == null) {
            return Collections.emptyList()
        }

        val listType = object : TypeToken<List<String?>?>() {}.type
        return Gson().fromJson(data, listType)
    }
    @TypeConverter
    fun sometToString(someObjects: List<String?>?): String {
        return Gson().toJson(someObjects)
    }

    @TypeConverter
    fun floatToSome(data: String?):  List<Float?>? {
        if (data == null) {
            return Collections.emptyList()
        }

        val listType = object : TypeToken<List<Float?>?>() {}.type
        return Gson().fromJson(data, listType)
    }
    @TypeConverter
    fun sometToFloat(someObjects: List<Float?>?): String {
        return Gson().toJson(someObjects)
    }


    @TypeConverter
    fun regionalBlocToString(someObjects: List<RegionalBloc?>?): String {
        return Gson().toJson(someObjects)
    }

    @TypeConverter
    fun fromStringTrans(value: String?): Translations? {
        val listType = object : TypeToken<Translations?>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromListTrans(list: Translations?): String? {
        return Gson().toJson(list)
    }


}

class RegionTypeConverters {

    @TypeConverter
    fun stringToSomeObjectList(data: String?):  List<com.example.sonetassignment.model.regionModelList.Currency?> {
        if (data == null) {
            return Collections.emptyList()
        }

        val listType = object : TypeToken<List<com.example.sonetassignment.model.regionModelList.Currency?>>() {}.type
        return Gson().fromJson(data, listType)
    }
    @TypeConverter
    fun someObjectListToString(someObjects: List<com.example.sonetassignment.model.regionModelList.Currency?>): String {
        return Gson().toJson(someObjects)
    }

    @TypeConverter
    fun languageToSomeObjectList(data: String?):  List<com.example.sonetassignment.model.regionModelList.Language?>? {
        if (data == null) {
            return Collections.emptyList()
        }

        val listType = object : TypeToken<List<com.example.sonetassignment.model.regionModelList.Language?>?>() {}.type
        return Gson().fromJson(data, listType)
    }

    @TypeConverter
    fun languageBlocToString(someObjects: List<com.example.sonetassignment.model.regionModelList.Language?>?): String {
        return Gson().toJson(someObjects)
    }

    @TypeConverter
    fun regionalBlocToSomeObjectList(data: String?):  List<com.example.sonetassignment.model.regionModelList.RegionalBloc?>? {
        if (data == null) {
            return Collections.emptyList()
        }

        val listType = object : TypeToken<List<com.example.sonetassignment.model.regionModelList.RegionalBloc?>?>() {}.type
        return Gson().fromJson(data, listType)
    }

    @TypeConverter
    fun regionBlocToString(someObjects: List<com.example.sonetassignment.model.regionModelList.RegionalBloc?>?): String {
        return Gson().toJson(someObjects)
    }

    @TypeConverter
    fun stringToSome(data: String?):  List<String?>? {
        if (data == null) {
            return Collections.emptyList()
        }

        val listType = object : TypeToken<List<String?>?>() {}.type
        return Gson().fromJson(data, listType)
    }
    @TypeConverter
    fun sometToString(someObjects: List<String?>?): String {
        return Gson().toJson(someObjects)
    }

    @TypeConverter
    fun floatToSome(data: String?):  List<Float?>? {
        if (data == null) {
            return Collections.emptyList()
        }

        val listType = object : TypeToken<List<Float?>?>() {}.type
        return Gson().fromJson(data, listType)
    }
    @TypeConverter
    fun sometToFloat(someObjects: List<Float?>?): String {
        return Gson().toJson(someObjects)
    }


    @TypeConverter
    fun regionalBlocToString(someObjects: List<com.example.sonetassignment.model.regionModelList.Translations?>?): String {
        return Gson().toJson(someObjects)
    }

    @TypeConverter
    fun fromStringTrans(value: String?): com.example.sonetassignment.model.regionModelList.Translations? {
        val listType = object : TypeToken<com.example.sonetassignment.model.regionModelList.Translations?>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromListTrans(list: com.example.sonetassignment.model.regionModelList.Translations?): String? {
        return Gson().toJson(list)
    }


}
