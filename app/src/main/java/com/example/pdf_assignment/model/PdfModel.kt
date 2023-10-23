package com.example.pdf_assignment.model

import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Parcel
import android.os.Parcelable
import android.util.Base64
import androidx.core.content.ContextCompat
import com.example.pdf_assignment.R
import java.io.ByteArrayOutputStream

data class PdfModel(
    val id: Int,
    val image: Drawable?,
    val status: String?,
    val pdfName: String?,
    val description: String?,
    val price: Int,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readParcelable(Drawable::class.java.classLoader),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(drawableToBase64(image))
        parcel.writeString(status)
        parcel.writeString(pdfName)
        parcel.writeString(description)
        parcel.writeInt(price)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PdfModel> {
        override fun createFromParcel(parcel: Parcel): PdfModel {
            return PdfModel(parcel)
        }

        override fun newArray(size: Int): Array<PdfModel?> {
            return arrayOfNulls(size)
        }
    }

    private fun drawableToBase64(drawable: Drawable?): String {
        val byteArrayOutputStream = ByteArrayOutputStream()
        drawable?.let { d ->
            (d as BitmapDrawable).bitmap.compress(
                Bitmap.CompressFormat.PNG,
                100,
                byteArrayOutputStream
            )
            val byteArray = byteArrayOutputStream.toByteArray()
            return Base64.encodeToString(byteArray, Base64.DEFAULT)
        } ?: return ""
    }

    private fun drawableFromBase64(base64String: String?): Drawable? {
        base64String?.let {
            val decodedBytes = Base64.decode(it, Base64.DEFAULT)
            val bitmap = BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.size)
            return BitmapDrawable(Resources.getSystem(), bitmap)
        } ?: return null
    }
}

fun getList(context: Context): List<PdfModel> {
    val list: MutableList<PdfModel> = ArrayList()

    val drawableOne = ContextCompat.getDrawable(context, R.drawable.pdf_image_one)
    val drawableTwo = ContextCompat.getDrawable(context, R.drawable.pdf_image_two)

    list.add(
        PdfModel(
            1,
            drawableOne!!,
            "4%",
            "Law Book - Redifining Family Law in India(Section 123",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ac volutpat ligula. Praesent aliquam volutpat consectetur. Vivamus ac laoreet arcu. Fusce id ex at massa malesuada vehicula. Sed congue odio nec erat tempus elementum. Vivamus id justo ut tortor hendrerit tincidunt. Sed at vehicula ipsum. Proin sed justo a nulla venenatis tincidunt. Aenean id ultrices elit. Sed ut quam id nulla tincidunt iaculis at eget orci. Phasellus id ultricies ex. Sed ultrices efficitur leo, a hendrerit mi cursus sit amet. Sed at lectus vitae est dictum egestas. In non euismod mi.",
            249
        )
    )
    list.add(
        PdfModel(
            2,
            drawableTwo!!,
            "4%",
            "Law Book - Redifining Family Law in India(Section 123",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ac volutpat ligula. Praesent aliquam volutpat consectetur. Vivamus ac laoreet arcu. Fusce id ex at massa malesuada vehicula. Sed congue odio nec erat tempus elementum. Vivamus id justo ut tortor hendrerit tincidunt. Sed at vehicula ipsum. Proin sed justo a nulla venenatis tincidunt. Aenean id ultrices elit. Sed ut quam id nulla tincidunt iaculis at eget orci. Phasellus id ultricies ex. Sed ultrices efficitur leo, a hendrerit mi cursus sit amet. Sed at lectus vitae est dictum egestas. In non euismod mi.",
            249
        )
    )
    list.add(
        PdfModel(
            3,
            drawableOne,
            "4%",
            "Law Book - Redifining Family Law in India(Section 123",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ac volutpat ligula. Praesent aliquam volutpat consectetur. Vivamus ac laoreet arcu. Fusce id ex at massa malesuada vehicula. Sed congue odio nec erat tempus elementum. Vivamus id justo ut tortor hendrerit tincidunt. Sed at vehicula ipsum. Proin sed justo a nulla venenatis tincidunt. Aenean id ultrices elit. Sed ut quam id nulla tincidunt iaculis at eget orci. Phasellus id ultricies ex. Sed ultrices efficitur leo, a hendrerit mi cursus sit amet. Sed at lectus vitae est dictum egestas. In non euismod mi.",
            249
        )
    )
    list.add(
        PdfModel(
            4,
            drawableTwo,
            "4%",
            "Law Book - Redifining Family Law in India(Section 123",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ac volutpat ligula. Praesent aliquam volutpat consectetur. Vivamus ac laoreet arcu. Fusce id ex at massa malesuada vehicula. Sed congue odio nec erat tempus elementum. Vivamus id justo ut tortor hendrerit tincidunt. Sed at vehicula ipsum. Proin sed justo a nulla venenatis tincidunt. Aenean id ultrices elit. Sed ut quam id nulla tincidunt iaculis at eget orci. Phasellus id ultricies ex. Sed ultrices efficitur leo, a hendrerit mi cursus sit amet. Sed at lectus vitae est dictum egestas. In non euismod mi.",
            1249
        )
    )
    list.add(
        PdfModel(
            5,
            drawableOne,
            "4%",
            "Law Book - Redifining Family Law in India(Section 123",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ac volutpat ligula. Praesent aliquam volutpat consectetur. Vivamus ac laoreet arcu. Fusce id ex at massa malesuada vehicula. Sed congue odio nec erat tempus elementum. Vivamus id justo ut tortor hendrerit tincidunt. Sed at vehicula ipsum. Proin sed justo a nulla venenatis tincidunt. Aenean id ultrices elit. Sed ut quam id nulla tincidunt iaculis at eget orci. Phasellus id ultricies ex. Sed ultrices efficitur leo, a hendrerit mi cursus sit amet. Sed at lectus vitae est dictum egestas. In non euismod mi.",
            249
        )
    )
    list.add(
        PdfModel(
            6,
            drawableTwo,
            "4%",
            "Law Book - Redifining Family Law in India(Section 123",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ac volutpat ligula. Praesent aliquam volutpat consectetur. Vivamus ac laoreet arcu. Fusce id ex at massa malesuada vehicula. Sed congue odio nec erat tempus elementum. Vivamus id justo ut tortor hendrerit tincidunt. Sed at vehicula ipsum. Proin sed justo a nulla venenatis tincidunt. Aenean id ultrices elit. Sed ut quam id nulla tincidunt iaculis at eget orci. Phasellus id ultricies ex. Sed ultrices efficitur leo, a hendrerit mi cursus sit amet. Sed at lectus vitae est dictum egestas. In non euismod mi.",
            249
        )
    )
    list.add(
        PdfModel(
            7,
            drawableOne,
            "4%",
            "Law Book - Redifining Family Law in India(Section 123",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ac volutpat ligula. Praesent aliquam volutpat consectetur. Vivamus ac laoreet arcu. Fusce id ex at massa malesuada vehicula. Sed congue odio nec erat tempus elementum. Vivamus id justo ut tortor hendrerit tincidunt. Sed at vehicula ipsum. Proin sed justo a nulla venenatis tincidunt. Aenean id ultrices elit. Sed ut quam id nulla tincidunt iaculis at eget orci. Phasellus id ultricies ex. Sed ultrices efficitur leo, a hendrerit mi cursus sit amet. Sed at lectus vitae est dictum egestas. In non euismod mi.",
            249
        )
    )
    list.add(
        PdfModel(
            8,
            drawableTwo,
            "4%",
            "Law Book - Redifining Family Law in India(Section 123",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ac volutpat ligula. Praesent aliquam volutpat consectetur. Vivamus ac laoreet arcu. Fusce id ex at massa malesuada vehicula. Sed congue odio nec erat tempus elementum. Vivamus id justo ut tortor hendrerit tincidunt. Sed at vehicula ipsum. Proin sed justo a nulla venenatis tincidunt. Aenean id ultrices elit. Sed ut quam id nulla tincidunt iaculis at eget orci. Phasellus id ultricies ex. Sed ultrices efficitur leo, a hendrerit mi cursus sit amet. Sed at lectus vitae est dictum egestas. In non euismod mi.",
            249
        )
    )
    list.add(
        PdfModel(
            9,
            drawableOne,
            "4%",
            "Law Book - Redifining Family Law in India(Section 123",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ac volutpat ligula. Praesent aliquam volutpat consectetur. Vivamus ac laoreet arcu. Fusce id ex at massa malesuada vehicula. Sed congue odio nec erat tempus elementum. Vivamus id justo ut tortor hendrerit tincidunt. Sed at vehicula ipsum. Proin sed justo a nulla venenatis tincidunt. Aenean id ultrices elit. Sed ut quam id nulla tincidunt iaculis at eget orci. Phasellus id ultricies ex. Sed ultrices efficitur leo, a hendrerit mi cursus sit amet. Sed at lectus vitae est dictum egestas. In non euismod mi.",
            1249
        )
    )
    list.add(
        PdfModel(
            10,
            drawableTwo,
            "4%",
            "Law Book - Redifining Family Law in India(Section 123",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ac volutpat ligula. Praesent aliquam volutpat consectetur. Vivamus ac laoreet arcu. Fusce id ex at massa malesuada vehicula. Sed congue odio nec erat tempus elementum. Vivamus id justo ut tortor hendrerit tincidunt. Sed at vehicula ipsum. Proin sed justo a nulla venenatis tincidunt. Aenean id ultrices elit. Sed ut quam id nulla tincidunt iaculis at eget orci. Phasellus id ultricies ex. Sed ultrices efficitur leo, a hendrerit mi cursus sit amet. Sed at lectus vitae est dictum egestas. In non euismod mi.",
            249
        )
    )
    list.add(
        PdfModel(
            11,
            drawableOne,
            "4%",
            "Law Book - Redifining Family Law in India(Section 123)",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ac volutpat ligula. Praesent aliquam volutpat consectetur. Vivamus ac laoreet arcu. Fusce id ex at massa malesuada vehicula. Sed congue odio nec erat tempus elementum. Vivamus id justo ut tortor hendrerit tincidunt. Sed at vehicula ipsum. Proin sed justo a nulla venenatis tincidunt. Aenean id ultrices elit. Sed ut quam id nulla tincidunt iaculis at eget orci. Phasellus id ultricies ex. Sed ultrices efficitur leo, a hendrerit mi cursus sit amet. Sed at lectus vitae est dictum egestas. In non euismod mi.",
            249
        )
    )
    list.add(
        PdfModel(
            12,
            drawableTwo,
            "4%",
            "Law Book - Redifining Family Law in India(Section 123",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ac volutpat ligula. Praesent aliquam volutpat consectetur. Vivamus ac laoreet arcu. Fusce id ex at massa malesuada vehicula. Sed congue odio nec erat tempus elementum. Vivamus id justo ut tortor hendrerit tincidunt. Sed at vehicula ipsum. Proin sed justo a nulla venenatis tincidunt. Aenean id ultrices elit. Sed ut quam id nulla tincidunt iaculis at eget orci. Phasellus id ultricies ex. Sed ultrices efficitur leo, a hendrerit mi cursus sit amet. Sed at lectus vitae est dictum egestas. In non euismod mi.",
            249
        )
    )
    list.add(
        PdfModel(
            13,
            drawableOne,
            "4%",
            "Law Book - Redifining Family Law in India(Section 123",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ac volutpat ligula. Praesent aliquam volutpat consectetur. Vivamus ac laoreet arcu. Fusce id ex at massa malesuada vehicula. Sed congue odio nec erat tempus elementum. Vivamus id justo ut tortor hendrerit tincidunt. Sed at vehicula ipsum. Proin sed justo a nulla venenatis tincidunt. Aenean id ultrices elit. Sed ut quam id nulla tincidunt iaculis at eget orci. Phasellus id ultricies ex. Sed ultrices efficitur leo, a hendrerit mi cursus sit amet. Sed at lectus vitae est dictum egestas. In non euismod mi.",
            249
        )
    )
    list.add(
        PdfModel(
            14,
            drawableTwo,
            "4%",
            "Law Book - Redifining Family Law in India(Section 123",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ac volutpat ligula. Praesent aliquam volutpat consectetur. Vivamus ac laoreet arcu. Fusce id ex at massa malesuada vehicula. Sed congue odio nec erat tempus elementum. Vivamus id justo ut tortor hendrerit tincidunt. Sed at vehicula ipsum. Proin sed justo a nulla venenatis tincidunt. Aenean id ultrices elit. Sed ut quam id nulla tincidunt iaculis at eget orci. Phasellus id ultricies ex. Sed ultrices efficitur leo, a hendrerit mi cursus sit amet. Sed at lectus vitae est dictum egestas. In non euismod mi.",
            249
        )
    )
    list.add(
        PdfModel(
            15,
            drawableOne,
            "4%",
            "Law Book - Redifining Family Law in India(Section 123",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ac volutpat ligula. Praesent aliquam volutpat consectetur. Vivamus ac laoreet arcu. Fusce id ex at massa malesuada vehicula. Sed congue odio nec erat tempus elementum. Vivamus id justo ut tortor hendrerit tincidunt. Sed at vehicula ipsum. Proin sed justo a nulla venenatis tincidunt. Aenean id ultrices elit. Sed ut quam id nulla tincidunt iaculis at eget orci. Phasellus id ultricies ex. Sed ultrices efficitur leo, a hendrerit mi cursus sit amet. Sed at lectus vitae est dictum egestas. In non euismod mi.",
            249
        )
    )
    list.add(
        PdfModel(
            16,
            drawableTwo,
            "4%",
            "Law Book - Redifining Family Law in India(Section 123",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ac volutpat ligula. Praesent aliquam volutpat consectetur. Vivamus ac laoreet arcu. Fusce id ex at massa malesuada vehicula. Sed congue odio nec erat tempus elementum. Vivamus id justo ut tortor hendrerit tincidunt. Sed at vehicula ipsum. Proin sed justo a nulla venenatis tincidunt. Aenean id ultrices elit. Sed ut quam id nulla tincidunt iaculis at eget orci. Phasellus id ultricies ex. Sed ultrices efficitur leo, a hendrerit mi cursus sit amet. Sed at lectus vitae est dictum egestas. In non euismod mi.",
            249
        )
    )
    list.add(
        PdfModel(
            17,
            drawableOne,
            "4%",
            "Law Book - Redifining Family Law in India(Section 123",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ac volutpat ligula. Praesent aliquam volutpat consectetur. Vivamus ac laoreet arcu. Fusce id ex at massa malesuada vehicula. Sed congue odio nec erat tempus elementum. Vivamus id justo ut tortor hendrerit tincidunt. Sed at vehicula ipsum. Proin sed justo a nulla venenatis tincidunt. Aenean id ultrices elit. Sed ut quam id nulla tincidunt iaculis at eget orci. Phasellus id ultricies ex. Sed ultrices efficitur leo, a hendrerit mi cursus sit amet. Sed at lectus vitae est dictum egestas. In non euismod mi.",
            249
        )
    )
    list.add(
        PdfModel(
            18,
            drawableTwo,
            "4%",
            "Law Book - Redifining Family Law in India(Section 123",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ac volutpat ligula. Praesent aliquam volutpat consectetur. Vivamus ac laoreet arcu. Fusce id ex at massa malesuada vehicula. Sed congue odio nec erat tempus elementum. Vivamus id justo ut tortor hendrerit tincidunt. Sed at vehicula ipsum. Proin sed justo a nulla venenatis tincidunt. Aenean id ultrices elit. Sed ut quam id nulla tincidunt iaculis at eget orci. Phasellus id ultricies ex. Sed ultrices efficitur leo, a hendrerit mi cursus sit amet. Sed at lectus vitae est dictum egestas. In non euismod mi.",
            249
        )
    )

    return list
}