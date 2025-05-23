package com.droidcon.shared

object Constants {
    const val WEB_CLIENT_ID = "252503780150-r3763ej17bd10fl004d523jefr1k0i6u.apps.googleusercontent.com"
    const val TEST_URL = "https://www.droidcon.com/"

    const val PAYPAL_CLIENT_ID = ""
    const val PAYPAL_SECRET_ID = ""

    const val PAYPAL_AUTH_KEY = "$PAYPAL_CLIENT_ID:$PAYPAL_SECRET_ID"

    const val PAYPAL_AUTH_ENDPOINT = "https://api-m.sandbox.paypal.com/v1/oauth2/token"
    const val PAYPAL_CHECKOUT_ENDPOINT = "https://api-m.sandbox.paypal.com/v2/checkout/orders"

    const val RETURN_URL = "com.droidcon.athletica://paypal?success=true"
    const val CANCEL_URL = "com.droidcon.athletica://paypal?cancel=true"

    const val MAX_QUANTITY = 10
    const val MIN_QUANTITY = 1
}