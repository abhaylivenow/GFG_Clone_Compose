package com.example.samplecomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.materialIcon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.samplecomposeapp.ui.theme.SampleComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreenApp()
        }
    }
}

@Composable
fun HomeScreenApp() {
    val bgColor = Color(0xFFf2f2f2)
    Column(
        modifier = Modifier
            .background(bgColor)
            .fillMaxSize()
    ) {
        TopAppBar(
            backgroundColor = Color.White
        ) {
            topAppBar()
        }
        categoriesHeader("POPULAR CATEGORIES")
        popularCategoriesRecyclerView()
        categoriesHeader(headerTitle = "QUIZ")
        quizzesRecyclerView()
        categoriesHeader(headerTitle = "INTERVIEW")
        interviewLayout()
    }
}

@Composable
@Preview
fun topAppBar() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painterResource(R.drawable.gfg),
                "content description",
                modifier = Modifier.size(42.dp)
            )
            Text(
                "GeeksForGeeks",
                fontSize = 22.sp,
                modifier = Modifier.padding(start = 12.dp),
                color = Color.Black,
                fontFamily = FontFamily(
                    Font(R.font.poppins)
                )
            )
        }

        Image(
            painterResource(R.drawable.ic_search),
            "content description",
            modifier = Modifier
                .size(40.dp)
                .padding(end = 12.dp)
        )
    }
}

@Composable
fun categoriesHeader(headerTitle: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            headerTitle,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(12.dp),
            fontFamily = FontFamily(
                Font(R.font.poppins)
            )
        )
        viewAll()
    }
}

@Composable
fun viewAll() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(end = 14.dp)
    ) {
        Text(
            "View All",
            fontWeight = FontWeight.Light,
            fontFamily = FontFamily(
                Font(R.font.poppins)
            )
        )
        Image(
            painterResource(R.drawable.ic_arrow),
            "content description"
        )
    }
}

@Composable
fun popularCategoriesRecyclerView() {
    val popularCourses = remember { Lists.listOfPopularCourses }
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(
            popularCourses
        ) {
            courseListItem(courses = it)
        }
    }
}

// UI for each item
@Composable
fun courseListItem(courses: PopularCoursesModel) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(corner = CornerSize(4.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(horizontal = 8.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Column() {
                Text(
                    text = courses.courseName,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(bottom = 2.dp, start = 6.dp, top = 12.dp),
                    fontFamily = FontFamily(
                        Font(R.font.poppins)
                    )
                )
                Text(
                    text = courses.numberOfChapters,
                    color = Color.LightGray,
                    modifier = Modifier.padding(bottom = 8.dp, start = 6.dp),
                    fontFamily = FontFamily(
                        Font(R.font.poppins)
                    )
                )
            }
            Image(
                painterResource(id = courses.courseImage),
                contentDescription = "",
                modifier = Modifier
                    .size(50.dp)
                    .padding(end = 12.dp)
            )
        }
    }
    Spacer(modifier = Modifier.padding(4.dp))
}

@Composable
fun quizzesRecyclerView() {
    val quizzes = remember { Lists.listOfQuizzes }
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 4.dp),
    ) {
        items(
            quizzes
        ) {
            quizListItem(quiz = it)
        }
    }
}

@Composable
fun quizListItem(quiz: QuizModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 12.dp),
        shape = RoundedCornerShape(corner = CornerSize(4.dp))
    ) {
        Column(
            modifier = Modifier.width(IntrinsicSize.Max),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = quiz.name,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
                fontFamily = FontFamily(
                    Font(R.font.poppins)
                ),
                modifier = Modifier.padding(start = 12.dp, top = 8.dp, end = 8.dp)
            )
            Text(
                text = quiz.quizDetail,
                color = Color.LightGray,
                modifier = Modifier.padding(bottom = 12.dp, start = 12.dp, end = 8.dp, top = 12.dp),
                fontFamily = FontFamily(
                    Font(R.font.poppins)
                )
            )
        }
    }
}

@Composable
@Preview
fun interviewLayout() {
    Column() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            interviewBox(
                companyName = "Microsoft",
                companyLogo = R.drawable.microsoft_logo,
                numberOfQuestions = "381 Questions"
            )

            interviewBox(
                companyName = "Adobe",
                companyLogo = R.drawable.adobe_logo,
                numberOfQuestions = "130 Questions"
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            interviewBox(
                companyName = "Flipkart",
                companyLogo = R.drawable.flipcart_logo,
                numberOfQuestions = "114 Questions"
            )

            interviewBox(
                companyName = "Google",
                companyLogo = R.drawable.google_logo,
                numberOfQuestions = "68 Questions"
            )
        }
    }

}

@Composable
fun interviewBox(
    companyName: String,
    companyLogo: Int,
    numberOfQuestions: String
) {
    Card(
        modifier = Modifier
            .width(180.dp)
            .padding(bottom = 12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painterResource(id = companyLogo),
                contentDescription = "",
                modifier = Modifier.size(60.dp)
            )
            Column(
                modifier = Modifier.padding(start = 8.dp, end = 8.dp)
            ) {
                Text(
                    companyName,
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily(
                        Font(R.font.poppins)
                    )
                )
                Text(
                    numberOfQuestions,
                    fontSize = 12.sp,
                    fontFamily = FontFamily(
                        Font(R.font.poppins)
                    )
                )
            }
        }
    }
}

object Lists {
    val listOfPopularCourses = listOf<PopularCoursesModel>(
        PopularCoursesModel(
            courseName = "Algorithms",
            numberOfChapters = "09 Chapters",
            courseImage = R.drawable.course1_image
        ),
        PopularCoursesModel(
            courseName = "Data Structures",
            numberOfChapters = "07 Chapters",
            courseImage = R.drawable.course2_image
        ),
        PopularCoursesModel(
            courseName = "Languages",
            numberOfChapters = "05 Chapters",
            courseImage = R.drawable.course3_image
        )
    )

    val listOfQuizzes = listOf<QuizModel>(
        QuizModel(
            name = "Aptitude",
            quizDetail = "13 Quiz | 450 Questions"
        ),
        QuizModel(
            name = "Web Technologies Questions",
            quizDetail = "6 Quiz | 350 Questions"
        ),
        QuizModel(
            name = "Engineering Mathematics Questions",
            quizDetail = "11 Quiz | 550 Questions"
        ),
        QuizModel(
            name = "Python Quizzes",
            quizDetail = "13 Quiz | 450 Questions"
        ),
        QuizModel(
            name = "QA - Placement Quizzes",
            quizDetail = "13 Quiz | 450 Questions"
        ),
        QuizModel(
            name = "Computer Science Quizzes",
            quizDetail = "13 Quiz | 450 Questions"
        ),
    )
}













