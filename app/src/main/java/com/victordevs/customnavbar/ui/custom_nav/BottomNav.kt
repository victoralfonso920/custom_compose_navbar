package com.victordevs.customnavbar.ui.custom_nav

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Created by Victor Hernandez on 1/10/21.
// Proyect Custom NavBar
//contact victoralfonso920@gmail.com

@ExperimentalAnimationApi
@Composable
fun CustomBottomNavigation(
    currentScreenId: String,
    onItemSelected: (Screens) -> Unit
) {
    val items = Screens.Items.list
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .padding(8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
            items.forEach { item ->
                CustomBottomNavigationItem(item = item, isSelected = item.id == currentScreenId) {
                    Toast.makeText(context, "Clicked ${item.title}", Toast.LENGTH_SHORT).show()
                    onItemSelected(item)
                }
            }
    }
}

@ExperimentalAnimationApi
@Composable
fun CustomBottomNavigationItem(item: Screens, isSelected: Boolean, onClick: () -> Unit) {
    val background =
        if (isSelected) MaterialTheme.colors.primary.copy(alpha = 0.1f) else Color.Transparent
    val contentColor =
        if (isSelected) MaterialTheme.colors.primary else MaterialTheme.colors.onBackground
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .background(background)
            .clickable(onClick = onClick)
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Icon(
                imageVector = item.icon,
                contentDescription = null,
                tint = contentColor
            )

            AnimatedVisibility(visible = isSelected) {
                Text(
                    text = item.title,
                    color = contentColor
                )
            }
        }
    }
}

@ExperimentalAnimationApi
@Composable
@Preview
fun Prev1() {
    CustomBottomNavigation(currentScreenId = Screens.Home.id) {}
}

@ExperimentalAnimationApi
@Composable
@Preview
fun Prev2() {
    CustomBottomNavigationItem(item = Screens.Home, isSelected = true) {}
}