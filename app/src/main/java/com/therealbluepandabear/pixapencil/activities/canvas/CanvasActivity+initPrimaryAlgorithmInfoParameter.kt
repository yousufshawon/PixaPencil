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

package com.therealbluepandabear.pixapencil.activities.canvas

import com.therealbluepandabear.pixapencil.algorithms.*

fun CanvasActivity.initPrimaryAlgorithmInfoParameter() {
    primaryAlgorithmInfoParameter = AlgorithmInfoParameter.create(
        canvasCommandsHelperInstance,
        binding.activityCanvasDrawingView.drawingViewBitmap,
        viewModel.currentBitmapAction!!,
        getSelectedColor()
    )

    lineAlgorithm = LineAlgorithm(primaryAlgorithmInfoParameter)
    circleAlgorithm = CircleAlgorithm(primaryAlgorithmInfoParameter)
    filledCircleAlgorithm = CircleAlgorithm(primaryAlgorithmInfoParameter, filledMode = true)
    ellipseAlgorithm = EllipseAlgorithm(primaryAlgorithmInfoParameter)
    filledEllipseAlgorithm = EllipseAlgorithm(primaryAlgorithmInfoParameter, filledMode = true)
    rectangleAlgorithm = RectangleAlgorithm(primaryAlgorithmInfoParameter)
    visibleRectanglePreviewAlgorithm = RectanglePreviewAlgorithm(primaryAlgorithmInfoParameter, false)
    visibleSquarePreviewAlgorithm = SquarePreviewAlgorithm(primaryAlgorithmInfoParameter, invisibleMode = false)
    invisibleRectanglePreviewAlgorithm = RectanglePreviewAlgorithm(primaryAlgorithmInfoParameter, invisibleMode = true)
    filledRectangleAlgorithm = RectangleAlgorithm(primaryAlgorithmInfoParameter)
    invisibleSquarePreviewAlgorithm = SquarePreviewAlgorithm(primaryAlgorithmInfoParameter, invisibleMode = true)
}