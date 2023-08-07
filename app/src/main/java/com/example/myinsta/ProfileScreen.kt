package com.example.myinsta

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ProfileScreen(
    navController: NavController
) {
    var selectedIndex by remember {
        mutableStateOf(0)
    }
    Column(modifier = Modifier
        .fillMaxSize()
    ){
        Column(
            modifier = Modifier.fillMaxWidth().weight(90f)
        ) {
            TopBar(name = "amishs_xt", modifier = Modifier.padding(10.dp))
            Spacer(modifier = Modifier.height(2.dp))
            ProfileSection()
            Spacer(modifier = Modifier.height(10.dp))
            ButtonSection()
            Spacer(modifier = Modifier.height(10.dp))
            HighlightSection(
                highlights = listOf(
                    ImageWithText(
                        image = painterResource(id = R.drawable.meow_pfp),
                        text = "Highlight"
                    ),
                    ImageWithText(
                        image = painterResource(id = R.drawable.meow_pfp),
                        text = "Highlight"
                    ),
                    ImageWithText(
                        image = painterResource(id = R.drawable.meow_pfp),
                        text = "Highlight"
                    ),
                    ImageWithText(
                        image = painterResource(id = R.drawable.meow_pfp),
                        text = "Highlight"
                    ),
                    ImageWithText(
                        image = painterResource(id = R.drawable.meow_pfp),
                        text = "Highlight"
                    ),
                    ImageWithText(
                        image = painterResource(id = R.drawable.meow_pfp),
                        text = "Highlight"
                    ),
                    ImageWithText(
                        image = painterResource(id = R.drawable.meow_pfp),
                        text = "Highlight"
                    ),
                    ImageWithText(
                        image = painterResource(id = R.drawable.meow_pfp),
                        text = "Highlight"
                    )
                )

            )
            Spacer(modifier = Modifier.height(10.dp))
            PostTabView(
                imageWithTexts = listOf(
                    ImageWithText(
                        image = painterResource(id = R.drawable.ic_grid),
                        text = "Posts"
                    ),
                    ImageWithText(
                        image = painterResource(id = R.drawable.ic_reels),
                        text = "Reels"
                    ),
                    ImageWithText(
                        image = painterResource(id = R.drawable.ic_igtv),
                        text = "IGTV"
                    ),
                    ImageWithText(
                        image = painterResource(id = R.drawable.tagged),
                        text = "Tagged"
                    )
                ),
            ){
                selectedIndex = it
            }
            when(selectedIndex){
                0 -> PostSection(
                    posts = listOf(
                        painterResource(id = R.drawable.meow_pfp),
                        painterResource(id = R.drawable.meow_pfp),
                        painterResource(id = R.drawable.meow_pfp),
                        painterResource(id = R.drawable.meow_pfp),
                        painterResource(id = R.drawable.meow_pfp),
                        painterResource(id = R.drawable.meow_pfp),
                        painterResource(id = R.drawable.meow_pfp),
                        painterResource(id = R.drawable.meow_pfp),
                        painterResource(id = R.drawable.meow_pfp),
                        painterResource(id = R.drawable.meow_pfp),
                        painterResource(id = R.drawable.meow_pfp),
                        painterResource(id = R.drawable.meow_pfp),
                        painterResource(id = R.drawable.meow_pfp),
                        painterResource(id = R.drawable.meow_pfp),
                        painterResource(id = R.drawable.meow_pfp),
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}


@Composable
fun TopBar(
    name: String,
    modifier: Modifier = Modifier
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.weight( 70f)
        ){
            Icon(imageVector = Icons.Default.ArrowBack,
                contentDescription ="Back",
                tint = Color.Black,
                modifier=modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text= name,
                overflow= TextOverflow.Ellipsis,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            Icon(painter = painterResource(id = R.drawable.ic_bell),
                contentDescription ="Notification",
                tint = Color.Black,
                modifier= modifier.size(24.dp)
            )
            Icon(painter = painterResource(id = R.drawable.ic_dotmenu),
                contentDescription ="Options",
                tint = Color.Black,
                modifier= modifier.size(24.dp)
            )
        }
    }
}

@Composable
fun ProfileSection(
    modifier: Modifier = Modifier
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            RoundImage(
                image = painterResource(id = R.drawable.meow_pfp),
                modifier = modifier
                    .size(100.dp)
                    .weight(3f)
            )
            Spacer(modifier = modifier.width(16.dp))
            StatSection(modifier = modifier.weight(7f))
        }
        ProfileDescription(
            displayName = "XT SENPAI",
            description = "Into futuristic R&B music \uD83C\uDFC3\n" +
                    "@inspiredisland my lord \uD83D\uDED0\n" +
                    "I do edits when motivation kicks in!",
            followedBy = listOf("puneet_superstar","andrew_tate"),
            otherCount = 69
        )
    }
}


@Composable
fun RoundImage(
    image: Painter,
    modifier: Modifier = Modifier
){
    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = CircleShape
            )
            .padding(3.dp)
            .clip(CircleShape)
    )
}

@Composable
fun StatSection(modifier: Modifier = Modifier){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
    ) {
        ProfileStat(numberText = "19", text = "Posts")
        ProfileStat(numberText = "497", text = "Followers")
        ProfileStat(numberText = "295", text = "Following")
    }
}

@Composable
fun ProfileStat(
    numberText: String,
    text: String,
    modifier: Modifier = Modifier
){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = numberText,
            fontWeight = FontWeight.Bold,
            modifier = modifier
        )

        Spacer(modifier = modifier.height(4.dp))

        Text(text = text)
    }

}

@Composable
fun ProfileDescription(
    displayName: String,
    description: String,
    followedBy: List<String>,
    otherCount: Int
){
    val letterSpacing = 0.5.sp
    val lineHeight = 20.sp
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ){
        Text(
            text = displayName,
            fontWeight = FontWeight.Bold,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = description,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        if(followedBy.isNotEmpty()){
            Text(
                text = buildAnnotatedString{
                    val boldStyle = SpanStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                    append("Followed By ")
                    followedBy.forEachIndexed{ index, name ->
                        pushStyle(boldStyle)
                        append(name)
                        pop()
                        if(index < followedBy.size-1){
                            append(", ")
                        }
                    }
                    if(otherCount > 2){
                        append(" and ")
                        pushStyle(boldStyle)
                        append("$otherCount others")
                    }
                },
                letterSpacing = letterSpacing,
                lineHeight = lineHeight
            )
        }
    }
}

@Composable
fun ButtonSection(
    modifier: Modifier = Modifier
){
    val minWidth = 95.dp
    val height = 30.dp
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier.fillMaxWidth()
    ){
        ActionButton(
            text = "Following",
            icon = Icons.Default.KeyboardArrowDown,
            modifier = modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            text = "Message",
            modifier = modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            text = "Email",
            modifier = modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            icon = Icons.Default.KeyboardArrowDown,
            modifier = modifier.height(height)
        )
    }
}

@Composable
fun ActionButton(
    modifier: Modifier = Modifier,
    text: String? = null,
    icon: ImageVector? = null
){
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(5.dp)
            )
            .padding(6.dp)
    ){
        if(text != null){
            Text(
                text = text,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp
            )
        }
        if(icon != null){
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.Black
            )
        }
    }
}

@Composable
fun HighlightSection(
    modifier: Modifier = Modifier,
    highlights: List<ImageWithText>
) {
    LazyRow(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        items(highlights.size) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = modifier
                    .padding(end = 15.dp)
            ) {
                RoundImage(
                    image = highlights[it].image,
                    modifier = modifier.size(70.dp)
                )
                Text(
                    text = highlights[it].text,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun PostTabView(
    modifier: Modifier = Modifier,
    imageWithTexts: List<ImageWithText>,
    onTabSelected: (selectedIndex: Int) -> Unit
) {
    var selectedIndex by remember {
        mutableStateOf(0)
    }
    val inactiveColor = Color(0xFF777777)
    TabRow(
        selectedTabIndex = selectedIndex,
        backgroundColor = Color.Transparent,
        contentColor = Color.Black,
        modifier = modifier
    ) {
        imageWithTexts.forEachIndexed { index, item ->
            Tab(selected = selectedIndex == index,
                onClick = {
                    selectedIndex = index
                    onTabSelected(index)
                }
            ) {
                Icon(
                    painter = item.image,
                    contentDescription = item.text,
                    tint = if (selectedIndex == index) Color.Black
                    else inactiveColor,
                    modifier = modifier
                        .padding(10.dp)
                        .size(20.dp)
                )
            }

        }

    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PostSection(
    posts: List<Painter>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(3),
        modifier = modifier.scale(1.01f)
    ) {
        items(posts.size){
            Image(
                painter = posts[it],
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .aspectRatio(1f)
                    .border(
                        width = 1.dp,
                        color = Color.White
                    )
            )
        }

    }
}


