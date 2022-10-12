/*
 * PixaPencil
 * Copyright 2022  therealbluepandabear
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.therealbluepandabear.pixapencil.activities.canvas.canvashelpers

import com.therealbluepandabear.pixapencil.activities.canvas.CanvasActivity
import com.therealbluepandabear.pixapencil.enums.RotationValue

fun CanvasActivity.rotate(rotationValue: RotationValue) {
    rotate(rotationValue.degrees, rotationValue.clockwise)
}

fun CanvasActivity.rotate(degrees: Float, clockwise: Boolean = true) {
//    val rotationAmount = if (clockwise || degrees == RotationValue.OneEighty.degrees) {
//        (binding.activityCanvasCardView.rotation + degrees)
//    } else {
//        (binding.activityCanvasCardView.rotation - degrees)
//    }
//
//    binding.activityCanvasCardView.rotation = rotationAmount
//    viewModel.currentRotation = rotationAmount
}