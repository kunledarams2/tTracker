package com.e.ttracker


import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
//import com.google.accompanist.flowlayout.FlowColumn

@Preview(showBackground = true)

@Composable
fun HeaderView() {

    Column(
        Modifier


    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(all = 10.dp)
        ) {
            Image(
                painterResource(id = R.drawable.ic_group),
                contentDescription = "",
                alignment = Alignment.CenterStart,
                modifier = Modifier.weight(1f)
            )

            Image(
                painterResource(id = R.drawable.front_image),
                contentDescription = "",
                alignment = Alignment.CenterEnd,

                modifier = Modifier
                    .clip(CircleShape)
                    .height(30.dp)
                    .width(30.dp)


            )
        }
        Row(
            Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Task Tracker",
                style = TextStyle(
                    fontSize = 18.sp, fontFamily = FontFamily(
                        Font(R.font.poppins_bold)
                    ), textAlign = TextAlign.Center

                )

            )
        }

        SampleScreen()


    }
}
@Composable
fun SampleScreen(){
    val taskList = remember { DataProvider.taskDescription }

    Box{

        Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp)){
            LazyColumn{
                item{
                    TitleView()
                }
                items(
                    items = taskList,
                    itemContent = {
                        CreatedTaskHolder(it)
                    }
                )



                item{
                    GetProgressTaskData()
                    Spacer(modifier = Modifier.padding(top = 60.dp))
//                    ProgressTaskBar()
                    //other views
                }
            }
        }

    }
}

@Composable
fun TitleView() {
    var titleDpFieldValue by remember { mutableStateOf("I would like to take this opportunity to thank you for providing me with this golden opportunity. ") }
    var titleFieldValue by remember { mutableStateOf("") }
    val scrollState = rememberScrollState()




    Column(
        modifier = Modifier
            .fillMaxSize()

//            .verticalScroll(rememberScrollState())

    ) {

        Row(
            Modifier
                .fillMaxWidth()

        ) {

            TextField(

                value = titleFieldValue, onValueChange = { titleFieldValue = it },
                /*  modifier = Modifier
                      .padding(15.dp),*/

                textStyle = TextStyle(
                    color = Color.Black,
                    textDecoration = TextDecoration.None
                ),
                label = { Text(text = "Title", color = Color.Black) },
                colors = TextFieldDefaults.textFieldColors(

                    cursorColor = Color.White,
                    disabledLabelColor = Color.Red,
                    focusedIndicatorColor = Color.White,
                    unfocusedIndicatorColor = Color.White,
                    backgroundColor = Color.Transparent

                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions { KeyboardActions.Default.onNext },
                /* leadingIcon = {
                     Icon(
                         Icons.Filled.Person,
                         "contentDescription",
                         tint = Color.White
                     )
                 }*/

            )
            Image(
                painter = painterResource(id = R.drawable.ic_vector__10_), contentDescription = "",
                Modifier.padding(top = 20.dp)
            )
            Spacer(modifier = Modifier.width(20.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_group__2_), contentDescription = "",
                Modifier.padding(top = 20.dp)
            )

        }
        Card(
            shape = RoundedCornerShape(corner = CornerSize(10.dp)),
            backgroundColor = Color(0XFFB8FDBB), modifier = Modifier
                .fillMaxWidth()

                .height(145.dp)
        ) {

            TextField(

                value = titleDpFieldValue,/*"I would like to take this opportunity to thank you for providing me with this golden opportunity. \n"*/
                onValueChange = { titleDpFieldValue = it },


                textStyle = TextStyle(
                    color = Color.Black,
                    textDecoration = TextDecoration.None,
                    fontFamily = FontFamily(Font(R.font.poppins_light))
                ),

                colors = TextFieldDefaults.textFieldColors(

                    cursorColor = Color.Black,
                    disabledLabelColor = Color.Red,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    backgroundColor = Color.Transparent

                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions { KeyboardActions.Default.onNext },


                )

        }
        Spacer(modifier = Modifier.height(5.dp))

        Card(
            shape = RoundedCornerShape(corner = CornerSize(10.dp)),
            backgroundColor = Color(0XFFB8FDBB), modifier = Modifier
                .fillMaxWidth()

        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Image(
                    painterResource(id = R.drawable.ic_group__3_),
                    contentDescription = "",
                    Modifier.padding(10.dp)
                    /* .clip(CircleShape)
                     .height(30.dp)
                     .width(30.dp)*/
                )

                Image(
                    painterResource(id = R.drawable.ic_vector__11_),
                    contentDescription = "",
                    Modifier.padding(10.dp)
                )


                Image(
                    painterResource(id = R.drawable.ic_eva_color_palette_outline),
                    contentDescription = "",
                    Modifier.padding(10.dp)
                    /*Modifier
                        .clip(CircleShape)
                        .height(30.dp)
                        .width(30.dp)*/
                )

                Image(
                    painterResource(id = R.drawable.ic_vector__12_),
                    contentDescription = "",
                    Modifier.padding(10.dp)
                    /* Modifier
                         .clip(CircleShape)
                         .height(30.dp)
                         .width(30.dp)*/
                )
                Spacer(modifier = Modifier.width(110.dp))

                Image(
                    painterResource(id = R.drawable.ic_vector__13_),
                    contentDescription = "",
                    Modifier.padding(10.dp)
                    /* Modifier
                         .clip(CircleShape)
                         .height(30.dp)
                         .width(30.dp)*/
                )

                Image(
                    painterResource(id = R.drawable.ic_vector__15_),
                    contentDescription = "",
                    Modifier.padding(10.dp)
                    /* Modifier
                         .clip(CircleShape)
                         .height(30.dp)
                         .width(30.dp)*/
                )

                Image(
                    painterResource(id = R.drawable.ic_group_1817),
                    contentDescription = "",
                    Modifier.padding(10.dp)
                    /* Modifier
                         .clip(CircleShape)
                         .height(30.dp)
                         .width(30.dp)*/
                )

            }

        }
        TimeDateView()

    }



}

@Composable
fun TimeDateView() {
    val taskSlotedTimeList = remember { DataProvider.TaskTimeSlot }
    val extraSlotTimeList = remember {
        DataProvider.extraTimeSlot
    }
    Column(
        Modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
        ) {
            Image(
                painterResource(id = R.drawable.ic_group__4_),
                contentDescription = "",

            )

            Spacer(modifier = Modifier.width(20.dp))
            Text(

                text = "Jul 26, 2022",
                style = TextStyle(
                    fontSize = 14.sp, fontFamily = FontFamily(
                        Font(R.font.poppins_light)
                    ), textAlign = TextAlign.Center

                )

            )
            Spacer(modifier = Modifier.width(10.dp))

            DropDownView(taskSlotedTimeList, modifier = Modifier)

            Spacer(modifier = Modifier.width(100.dp))
            Checkbox(checked = false, onCheckedChange = {})
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = "All day",
                style = TextStyle(
                    fontSize = 14.sp, fontFamily = FontFamily(
                        Font(R.font.poppins_light)
                    ), textAlign = TextAlign.Center, color = Color(0XFF2D2F48)

                )

            )

        }


        Row(modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.width(38.dp))
            TaskRememberDropDown()
            /*  Text(

                  text = "Does not repeat",
                  style = TextStyle(
                      fontSize = 14.sp, fontFamily = FontFamily(
                          Font(R.font.poppins_light)
                      ), textAlign = TextAlign.Center, color = Color(0XFF2D2F48)

                  )


              )*/
            Image(
                painterResource(id = R.drawable.ic_baseline_expand_more_24),
                contentDescription = "",

                )


        }



        Row(
            Modifier.fillMaxWidth()
        ) {

            Image(
                painterResource(id = R.drawable.ic_vector__1_),
                contentDescription = "",

                Modifier
                    .padding(top = 20.dp)
            )
            Card(
                shape = RoundedCornerShape(corner = CornerSize(10.dp)),
                border = BorderStroke(2.dp, Color(0XFF2D2F48)),
                backgroundColor = Color.White,
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(10.dp)
                    .weight(1f)


            ) {
                DropDownView(taskSlotedTimeList, modifier = Modifier
                    .padding(5.dp)
                    .width(100.dp))
                /* Text(
                     modifier = Modifier
                         .padding(10.dp)
                         .width(100.dp),
                     text = "12:00 AM",
                     style = TextStyle(
                         fontSize = 14.sp, fontFamily = FontFamily(
                             Font(R.font.poppins_light)
                         ), textAlign = TextAlign.Center, color = Color(0XFF2D2F48)

                     )

                 )*/
            }
//            Divider()
            /*  Box(
                  modifier = Modifier
                      .width(20.dp)
                      .height(2.dp)
                      .background(Color.Black)
                      .padding(top = 100.dp)

              ) {

              }*/
            Card(
                shape = RoundedCornerShape(corner = CornerSize(10.dp)),
                border = BorderStroke(2.dp, Color(0XFF2D2F48)),
                backgroundColor = Color.White,
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(10.dp)
                    .weight(1f)

            ) {
                DropDownView(taskSlotedTimeList, modifier = Modifier
                    .padding(5.dp)
                    .width(100.dp))
            }

            Card(
                shape = RoundedCornerShape(corner = CornerSize(10.dp)),
                border = BorderStroke(2.dp, Color(0XFF2D2F48)),
                backgroundColor = Color(0XFFFDB8B8),
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(10.dp)
                    .weight(1f),

                ) {

                DropDownView(extraSlotTimeList, modifier = Modifier
                    .padding(5.dp)
                    .width(100.dp))
               /* Text(
                    modifier = Modifier
                        .padding(10.dp)
                        .width(100.dp),
                    text = "1hr:00:00",
                    style = TextStyle(
                        fontSize = 14.sp, fontFamily = FontFamily(
                            Font(R.font.poppins_light)
                        ), textAlign = TextAlign.Center, color = Color(0XFF2D2F48)

                    )

                )*/
            }

        }

//        CreatedTask()

    }
}

@Composable
fun CreatedTask() {

    Spacer(modifier = Modifier.height(30.dp))
//    GetTaskData()

   /* Row(
        Modifier
            .fillMaxWidth()


    ) {
        Text(
            modifier = Modifier
                .weight(1f),
            text = "Task Created",
            style = TextStyle(
                fontSize = 16.sp, fontFamily = FontFamily(
                    Font(R.font.poppins_light)
                ), textAlign = TextAlign.Start

            )

        )
        Image(
            painter = painterResource(id = R.drawable.ic_baseline_import_export_24),
            contentDescription = "",
            alignment = Alignment.CenterEnd,
            modifier = Modifier.weight(1f)

        )
    }

    Spacer(modifier = Modifier.height(10.dp))
    Card(
        shape = RoundedCornerShape(corner = CornerSize(10.dp)),
        backgroundColor = Color(0xFFD9D9D9),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize()
            .height(50.dp)

    ) {

        Row(
            Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {

            Checkbox(checked = false, onCheckedChange = {})
            Text(

                text = "Contact the CEO of Decagon",
                style = TextStyle(
                    fontSize = 12.sp, fontFamily = FontFamily(
                        Font(R.font.poppins_light)
                    ), textAlign = TextAlign.Start

                ),
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 10.dp, end = 10.dp)

            )
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly

            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_vector__10_),
                    contentDescription = "",


                    )
                Spacer(modifier = Modifier.width(5.dp))
                Image(
                    painter = painterResource(id = R.drawable.ic_outline_delete_24),
                    contentDescription = "",


                    )
            }

        }


    }
    Spacer(modifier = Modifier.height(10.dp))

    Card(
        shape = RoundedCornerShape(corner = CornerSize(10.dp)),
        backgroundColor = Color(0xFFCAB8FD),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize()
            .height(50.dp)

    ) {

        Row(
            Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {

            Checkbox(checked = false, onCheckedChange = {})
            Text(

                text = "Design the onboarding session of Task Tracker App",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = FontFamily(
                        Font(R.font.poppins_light)
                    ),
                    textAlign = TextAlign.Start,

                    ), maxLines = 6,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 10.dp, end = 10.dp)

            )
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly

                *//* modifier =  Modifier
                     .fillMaxSize()
                     .weight(1f)*//*
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_vector__10_),
                    contentDescription = "",


                    )

                Image(
                    painter = painterResource(id = R.drawable.ic_outline_delete_24),
                    contentDescription = "",


                    )
            }

        }


    }
    Spacer(modifier = Modifier.height(10.dp))

    Card(
        shape = RoundedCornerShape(corner = CornerSize(10.dp)),
        backgroundColor = Color(0xFFFDB8B8),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize()
            .height(50.dp)

    ) {

        Row(
            Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {

            Checkbox(checked = false, onCheckedChange = {})
            Text(

                text = "Remind the technical team to include the micro-interaction delivered",
                style = TextStyle(
                    fontSize = 12.sp, fontFamily = FontFamily(
                        Font(R.font.poppins_light)
                    ), textAlign = TextAlign.Start

                ),
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 10.dp, end = 10.dp)

            )
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly

                *//* modifier =  Modifier
                     .fillMaxSize()
                     .weight(1f)*//*
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_vector__10_),
                    contentDescription = "",
                )

                Image(
                    painter = painterResource(id = R.drawable.ic_outline_delete_24),
                    contentDescription = "",
                )
            }

        }


    }
    Spacer(modifier = Modifier.height(10.dp))*/



//    ProgressTaskBar()
}

@Composable
fun CreatedTaskHolder(taskModel: TaskModel){
    Spacer(modifier = Modifier.padding(top = 10.dp))
    Card(
        shape = RoundedCornerShape(corner = CornerSize(10.dp)),
        backgroundColor =taskModel.color,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize()
            .height(50.dp)

    ) {

        Row(
            Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {

            Checkbox(checked = false, onCheckedChange = {})
            Text(

                text = taskModel.description,
                style = TextStyle(
                    fontSize = 12.sp, fontFamily = FontFamily(
                        Font(R.font.poppins_light)
                    ), textAlign = TextAlign.Start

                ),
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 10.dp, end = 10.dp)

            )
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly

                /* modifier =  Modifier
                     .fillMaxSize()
                     .weight(1f)*/
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_vector__10_),
                    contentDescription = "",
                )

                Image(
                    painter = painterResource(id = R.drawable.ic_outline_delete_24),
                    contentDescription = "",
                )
            }

        }


    }
}

@Composable
fun GetProgressTaskData() {
    val taskList = remember { DataProvider.progressTaskSlot }
    Spacer(modifier = Modifier.padding(top = 20.dp))
    LazyRow(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)) {
        items(
            items = taskList,
            itemContent = {
                ProgressTaskBar(it)
            }
        )
    }
}

@Composable
fun ProgressTaskBar(taskProgressModel: TaskProgressModel) {
    Spacer(modifier = Modifier.padding(top = 20.dp, start = 20.dp))
    Column() {
        val mProgress = animateFloatAsState(targetValue = taskProgressModel.progress / 100)
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .background(Color.LightGray)
                .width(10.dp)
                .height(85.dp)

        ) {
            Box(
                modifier = Modifier
                    .weight((if ((1 - mProgress.value) == 0f) 0.0001 else 1 - mProgress.value) as Float)
                    .fillMaxWidth()
            )
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(5.dp))
                    .weight(mProgress.value)
                    .fillMaxWidth()
                    .background(
                        taskProgressModel.color
                        /* Color(0XFFB8FDBB)*/

                    )
            )

        }
        Text(
            text = taskProgressModel.task, style = TextStyle(
                fontSize = 12.sp, fontFamily = FontFamily(
                    Font(R.font.poppins_light)
                ), color = Color(0XFF2D2F48), textAlign = TextAlign.Start

            )
        )
    }



    Spacer(modifier = Modifier.height(100.dp))

}

@Composable
fun TaskRememberDropDown() {
    var expendable by remember {
        mutableStateOf(false)
    }
    var selectedItemIndex by remember {
        mutableStateOf(0)
    }
    val rememberItems = listOf(
        "Select Alarm Schedule",
        "Daily",
        "Weekly on Tuesday",
        "Monthly on the last Tuesday",
        "Monthly on the last Tuesday",
        "Annually on July 26",
        "Every weekday (Monday to Friday)",
        "Custom...",
    )
    Box(modifier = Modifier.width(250.dp)) {

        Text(

            text = rememberItems[selectedItemIndex],
            style = TextStyle(
                fontSize = 14.sp, fontFamily = FontFamily(
                    Font(R.font.poppins_light)
                ), textAlign = TextAlign.Center, color = Color(0XFF2D2F48)

            ), modifier = Modifier.clickable { expendable = true }


        )
        DropdownMenu(expanded = expendable, onDismissRequest = { expendable = false }) {
            rememberItems.forEachIndexed { index, s ->
                DropdownMenuItem(onClick = {
                    selectedItemIndex = index
                    expendable = false
                }) {
                    Text(
                        text = s, style = TextStyle(
                            fontSize = 14.sp, fontFamily = FontFamily(
                                Font(R.font.poppins_light)
                            ), textAlign = TextAlign.Center, color = Color(0XFF2D2F48)

                        )
                    )
                }
            }
        }
    }
}

@Composable
fun DropDownView(items: List<String>, modifier: Modifier) {
    var expendable by remember {
        mutableStateOf(false)
    }
    var selectedItemIndex by remember {
        mutableStateOf(0)
    }

    Box(modifier = modifier.wrapContentSize()) {

        Text(

            text = items[selectedItemIndex],
            style = TextStyle(
                fontSize = 14.sp, fontFamily = FontFamily(
                    Font(R.font.poppins_light)
                ), textAlign = TextAlign.Center, color = Color(0XFF2D2F48)

            ), modifier = modifier.clickable { expendable = true }


        )
        DropdownMenu(expanded = expendable, onDismissRequest = { expendable = false }) {
            items.forEachIndexed { index, s ->
                DropdownMenuItem(onClick = {
                    selectedItemIndex = index
                    expendable = false
                }) {
                    Text(
                        text = s, style = TextStyle(
                            fontSize = 14.sp, fontFamily = FontFamily(
                                Font(R.font.poppins_light)
                            ), textAlign = TextAlign.Center, color = Color(0XFF2D2F48)

                        )
                    )
                }
            }
        }
    }
}