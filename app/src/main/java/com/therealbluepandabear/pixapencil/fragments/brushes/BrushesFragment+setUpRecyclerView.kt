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

package com.therealbluepandabear.pixapencil.fragments.brushes

import android.content.res.Configuration
import androidx.recyclerview.widget.LinearLayoutManager
import com.therealbluepandabear.pixapencil.adapters.BrushesAdapter
import com.therealbluepandabear.pixapencil.database.BrushesDatabase

fun BrushesFragment.setUpRecyclerView() {
    val layoutManager = LinearLayoutManager(activity)

    val layoutManagerOrientation: Int = if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
        LinearLayoutManager.HORIZONTAL
    } else {
        LinearLayoutManager.VERTICAL
    }

    layoutManager.orientation = layoutManagerOrientation

    binding.fragmentBrushesRecyclerView.layoutManager = layoutManager

    binding.fragmentBrushesRecyclerView.adapter = BrushesAdapter(BrushesDatabase.toList(), this, this@setUpRecyclerView.requireContext())
}