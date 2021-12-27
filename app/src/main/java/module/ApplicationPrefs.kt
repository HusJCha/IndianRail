package module

import android.content.Context
import android.content.SharedPreferences

class ApplicationPrefs(private val context: Context) {

    private lateinit var prefsT: ApplicationPrefs

    private val PREF_NAME = "indianRailPrefs"

    private val USER_ID = "user_id"
    private val USER_DETAILS = "user_details"
    private val USER_DETAILS_ON_BOARDING = "user_details_on_boarding"
    private val FCM_TOKEN = "fcm_token"
    private val IS_PIN_SET = "is_pin_set"

    private val CITY_ID = "city_id"
    private val CITY_PINCODE = "city_pincode"
    private val EMAIl = "email"
    private val USER_ADDRESS = "user_address"
    private val USER_TOKEN = "user_token"
    private val NOTIFICATION_COUNT = "notification_count"
    private val OFFER_COUNT = "offer_count"
    private val LAST_USER_MOBILE_NO = "lastUserMobileNo"
    private val SMS_COUNT = "smsCount"


/*
    private fun ApplicationPrefs(context: Context): ApplicationPrefs {
        if (!this::prefsT.isInitialized) {
            this.context = context
            prefsT = ApplicationPrefs()
        }
        return prefsT
    }

    fun getInstance(context: Context): ApplicationPrefs {
        if (!this::prefsT.isInitialized) {
            prefsT = ApplicationPrefs(context)
        }
        return prefsT
    }*/

    fun setUserId(userId: String?) {
        setPreferencesData(USER_ID, userId)
    }

    fun getUserId(): String? {
        return getPreferenceData(USER_ID, null)
    }

    fun setLastUserMobileNo(lastUserMobileNo: String?) {
        setPreferencesData(LAST_USER_MOBILE_NO, lastUserMobileNo)
    }

    fun getLastUserMobileNo(): String? {
        return getPreferenceData(LAST_USER_MOBILE_NO, null)
    }

    /*fun setUserDetails(userDetail: UserDetails?) {
        val gson = Gson()
        setPreferencesData(USER_DETAILS, gson.toJson(userDetail))
    }

    fun getUserDetails(): UserDetails {
        val gson = Gson()
        return gson.fromJson(getPreferenceData(USER_DETAILS, ""), UserDetails::class.java)
    }*/

    fun setPinStatus(name: Boolean) {
        setPreferencesData(IS_PIN_SET, name)
    }

    fun getPinStatus(): Boolean {
        return getPreferenceData(IS_PIN_SET, false)
    }

    fun setNotificationCount(count: Int) {
        setPreferencesData(NOTIFICATION_COUNT, count)
    }

    fun getNotificationCount(): Int {
        return getPreferenceData(NOTIFICATION_COUNT, 0)
    }

    fun setOfferCount(count: Int) {
        setPreferencesData(OFFER_COUNT, count)
    }

    fun getOfferCount(): Int {
        return getPreferenceData(OFFER_COUNT, 0)
    }

    fun setCityPincode(cityPincode: String?) {
        setPreferencesData(CITY_PINCODE, cityPincode)
    }

    fun getCityPincode(): String? {
        return getPreferenceData(CITY_PINCODE, "")
    }

    fun setEmail(email: String?) {
        setPreferencesData(EMAIl, email)
    }

    fun getEmail(): String? {
        return getPreferenceData(EMAIl, null)
    }


    fun setUserToken(userToken: String?) {
        setPreferencesData(USER_TOKEN, userToken)
    }

    fun getUserToken(): String? {
        return getPreferenceData(USER_TOKEN, "")
    }


    fun setSmsCount(smsCount: String?) {
        setPreferencesData(SMS_COUNT, smsCount)
    }

    fun getSmsCount(): String? {
        return getPreferenceData(SMS_COUNT, "")
    }

    fun setFCMToken(userToken: String?) {
        setPreferencesData(FCM_TOKEN, userToken)
    }

    fun getFCMToken(): String? {
        return getPreferenceData(FCM_TOKEN, "")
    }

    fun isLogin(): Boolean {
        return getUserId() != null && getUserId()!!.trim { it <= ' ' }.isNotEmpty()
    }

    fun clearUser() {
//        setLastUserMobileNo(getSaloonDetail().mobile_no)
        setUserId(null)
        setSmsCount(null)
//        setUserDetails(null)
        setUserToken(null)
    }

    fun clear() {
        getPrefsEditor().clear().commit()
    }

    private fun getPrefs(): SharedPreferences {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    private fun getPrefsEditor(): SharedPreferences.Editor {
        return getPrefs().edit()
    }

    /*
     * Save string data type
     *
     * */
    private fun setPreferencesData(key: String, value: String?) {
        val editor = getPrefsEditor()
        editor.putString(key, value)
        editor.commit()
    }

    /*
     * Save Int data type
     *
     * */
    private fun setPreferencesData(key: String, value: Int) {
        val editor = getPrefsEditor()
        editor.putInt(key, value)
        editor.commit()
    }

    /*
     * Save Long data type
     *
     * */
    private fun setPreferencesData(key: String, value: Long) {
        val editor = getPrefsEditor()
        editor.putLong(key, value)
        editor.commit()
    }

    /*
     * Save boolean data type
     *
     * */
    private fun setPreferencesData(key: String, value: Boolean) {
        val editor = getPrefsEditor()
        editor.putBoolean(key, value)
        editor.commit()
    }

    /*
     * Save float data type
     *
     * */
    private fun setPreferencesData(key: String, value: Float) {
        val editor = getPrefsEditor()
        editor.putFloat(key, value)
        editor.commit()
    }

    /*
     *
     * fetch  method for pref
     *
     * */

    /*
     *
     * fetch  method for pref
     *
     * */
    /*
     *  getPreferenceData String data from pref
     * */
    private fun getPreferenceData(key: String, defaultValue: String?): String? {
        return getPrefs().getString(key, defaultValue)
    }

    /*
     *  getPreferenceData int data from pref
     * */
    private fun getPreferenceData(key: String, defaultValue: Int): Int {
        return getPrefs().getInt(key, defaultValue)
    }

    /*
     *  getPreferenceData boolean data from pref
     * */
    private fun getPreferenceData(key: String, defaultValue: Boolean): Boolean {
        return getPrefs().getBoolean(key, defaultValue)
    }

    /*
     *  getPreferenceData long data from pref
     * */
    private fun getPreferenceData(key: String, defaultValue: Long): Long {
        return getPrefs().getLong(key, defaultValue)
    }
}