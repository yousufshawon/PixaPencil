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

package com.therealbluepandabear.pixapencil.tooltests.tests

import android.graphics.Color
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.therealbluepandabear.pixapencil.activities.canvas.CanvasActivity
import com.therealbluepandabear.pixapencil.extensions.getPixel
import com.therealbluepandabear.pixapencil.extensions.setPixel
import com.therealbluepandabear.pixapencil.models.Coordinate
import com.therealbluepandabear.pixapencil.tooltests.helper.ToolTestsHelper
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.random.Random

@RunWith(AndroidJUnit4::class)
@LargeTest
class FindAndReplaceToolTests {
    private fun setRandomPixels(activity: CanvasActivity, iterations: Int, color: Int = Color.BLACK): List<Coordinate> {
        val randomCoordinates: MutableList<Coordinate> = mutableListOf()

        for (i in 0..iterations) {
            val randomCoordinate = Coordinate(Random.nextInt(0, activity.width), Random.nextInt(0, activity.height))
            randomCoordinates.add(randomCoordinate)

            activity.binding.activityCanvasDrawingView.drawingViewBitmap.setPixel(randomCoordinate, color)
        }

        return randomCoordinates
    }

    @get:Rule
    val activityRule = ActivityScenarioRule(CanvasActivity::class.java)

    @Test
    fun rnd_fartt_1() {
        activityRule.scenario.onActivity {
            ToolTestsHelper.prepare(it)

            val iterations = 200
            val randomCoordinates: List<Coordinate> = setRandomPixels(it, iterations)

            // For all tests after this: this is the specific onDoneButtonPressed function for the 'Done' button in the 'Find and Replace' fragment.
            it.onDoneButtonPressed(Color.BLACK, Color.YELLOW)

            for (coordinate in randomCoordinates) {
                assert(it.binding.activityCanvasDrawingView.drawingViewBitmap.getPixel(coordinate) == Color.YELLOW)
            }
        }
    }

    @Test
    fun rnd_fartt_2() {
        activityRule.scenario.onActivity {
            ToolTestsHelper.prepare(it)

            val iterations = 2000
            val randomCoordinates: List<Coordinate> = setRandomPixels(it, iterations)

            it.onDoneButtonPressed(Color.BLACK, Color.CYAN)

            for (coordinate in randomCoordinates) {
                assert(it.binding.activityCanvasDrawingView.drawingViewBitmap.getPixel(coordinate) == Color.CYAN)
            }
        }
    }

    @Test
    fun rnd_fartt_3() {
        activityRule.scenario.onActivity {
            ToolTestsHelper.prepare(it)

            val iterations1 = 3000
            val randomCoordinate1: List<Coordinate> = setRandomPixels(it, iterations1, Color.RED)

            it.onDoneButtonPressed(Color.RED, Color.BLACK)

            for (coordinate in randomCoordinate1) {
                assert(it.binding.activityCanvasDrawingView.drawingViewBitmap.getPixel(coordinate) == Color.BLACK)
            }

            val iterations2 = 500
            val randomCoordinate2: List<Coordinate> = setRandomPixels(it, iterations2, Color.LTGRAY)

            it.onDoneButtonPressed(Color.LTGRAY, Color.MAGENTA)

            for (coordinate in randomCoordinate2) {
                assert(it.binding.activityCanvasDrawingView.drawingViewBitmap.getPixel(coordinate) == Color.MAGENTA)
            }
        }
    }
}