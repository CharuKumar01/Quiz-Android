package com.example.quiz

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.quiz.databinding.FragmentQuizBinding

class QuizFragment : Fragment() {
    private lateinit var bind: FragmentQuizBinding

    private val scienceQuestions: MutableList<ScienceQuestion> = mutableListOf(
        ScienceQuestion(
            text = "Which planet is known as the Red Planet?",
            answers = mutableListOf("Mars", "Jupiter", "Venus", "Saturn")
        ),
        ScienceQuestion(
            text = "What gas do plants primarily take in during photosynthesis?",
            answers = mutableListOf("Carbon dioxide", "Oxygen", "Nitrogen", "Hydrogen")
        ),
        ScienceQuestion(
            text = "How many bones are there in the adult human body?",
            answers = mutableListOf("206", "210", "205", "208")
        ),
        ScienceQuestion(
            text = "What is the center of an atom called?",
            answers = mutableListOf("Nucleus", "Proton", "Electron", "Molecule")
        ),
        ScienceQuestion(
            text = "What is the main gas found in the air we breathe?",
            answers = mutableListOf("Nitrogen", "Carbon dioxide", "Hydrogen", "Oxygen")
        ), ScienceQuestion(
            text = "Which is the largest planet in our solar system?",
            answers = listOf("Jupiter", "Earth", "Saturn", "Neptune")
        ),
        ScienceQuestion(
            text = "What is the hardest natural substance on Earth?",
            answers = listOf("Diamond", "Iron", "Granite", "Quartz")
        ),
        ScienceQuestion(
            text = "Which part of the cell contains genetic material?",
            answers = listOf("Nucleus", "Cytoplasm", "Mitochondria", "Ribosome")
        ),
        ScienceQuestion(
            text = "What is the boiling point of water at sea level?",
            answers = listOf("100°C", "90°C", "110°C", "120°C")
        ),
        ScienceQuestion(
            text = "What is the process by which plants make their food?",
            answers = listOf("Photosynthesis", "Respiration", "Digestion", "Fermentation")
        ),
        ScienceQuestion(
            text = "What planet is closest to the Sun?",
            answers = listOf("Mercury", "Venus", "Earth", "Mars")
        ),
        ScienceQuestion(
            text = "What organ in the human body filters blood?",
            answers = listOf("Kidney", "Heart", "Liver", "Lungs")
        ),
        ScienceQuestion(
            text = "Which of these is a primary color of light?",
            answers = listOf("Green", "Orange", "Purple", "Pink")
        ),
        ScienceQuestion(
            text = "What type of energy does a moving object have?",
            answers = listOf("Kinetic energy", "Potential energy", "Thermal energy", "Chemical energy")
        ),
        ScienceQuestion(
            text = "What is the main function of red blood cells?",
            answers = listOf("Carry oxygen", "Fight infections", "Clot blood", "Store nutrients")
        ),
        ScienceQuestion(
            text = "What is the chemical formula for table salt?",
            answers = listOf("NaCl", "KCl", "HCl", "CaCl")
        ),
        ScienceQuestion(
            text = "Which layer of the Earth is made of liquid metal?",
            answers = listOf("Outer core", "Crust", "Mantle", "Inner core")
        ),
        ScienceQuestion(
            text = "What is the largest organ in the human body?",
            answers = listOf("Skin", "Liver", "Brain", "Heart")
        ),
        ScienceQuestion(
            text = "What force keeps planets in orbit around the Sun?",
            answers = listOf("Gravity", "Magnetism", "Electromagnetic force", "Centrifugal force")
        ),
        ScienceQuestion(
            text = "What is the smallest unit of life?",
            answers = listOf("Cell", "Atom", "Molecule", "Organ")
        ),
        ScienceQuestion(
            text = "Which gas is most abundant in the Earth's atmosphere?",
            answers = listOf("Nitrogen", "Oxygen", "Carbon dioxide", "Argon")
        ),
        ScienceQuestion(
            text = "What is the primary source of energy for Earth?",
            answers = listOf("The Sun", "The Moon", "Volcanoes", "Geothermal energy")
        ),
        ScienceQuestion(
            text = "What is the powerhouse of the cell?",
            answers = listOf("Mitochondria", "Nucleus", "Ribosome", "Cytoplasm")
        ),
        ScienceQuestion(
            text = "What is the name of the galaxy we live in?",
            answers = listOf("Milky Way", "Andromeda", "Triangulum", "Sombrero")
        ),
        ScienceQuestion(
            text = "What is the speed of light in a vacuum?",
            answers = listOf("299,792 km/s", "150,000 km/s", "1,080 km/s", "500,000 km/s")
        ),
        ScienceQuestion(
            text = "What is the basic unit of heredity?",
            answers = listOf("Gene", "Chromosome", "DNA", "Protein")
        ),
        ScienceQuestion(
            text = "What does DNA stand for?",
            answers = listOf(
                "Deoxyribonucleic Acid",
                "Deoxyribosomal Acid",
                "Dioxygen Nucleic Acid",
                "Dynamic Nucleic Acid"
            )
        ),
        ScienceQuestion(
            text = "Which organ in the body is responsible for pumping blood?",
            answers = listOf("Heart", "Liver", "Brain", "Kidney")
        ),
        ScienceQuestion(
            text = "What is the main function of white blood cells?",
            answers = listOf("Fight infections", "Carry oxygen", "Clot blood", "Store nutrients")
        ),
        ScienceQuestion(
            text = "Which planet has the most moons in the solar system?",
            answers = listOf("Saturn", "Jupiter", "Neptune", "Uranus")
        )
    )
    private val historyQuestion: MutableList<HistoryQuestion> = mutableListOf(
        HistoryQuestion(
            text = "Who was the first President of the United States?",
            answers = mutableListOf("George Washington", "Thomas Jefferson", "John Adams", "James Madison")
        ),
        HistoryQuestion(
            text = "In which year did World War II end?",
            answers = mutableListOf("1945", "1940", "1939", "1950")
        ),
        HistoryQuestion(
            text = "Which ancient civilization built the pyramids?",
            answers = mutableListOf("Egyptians", "Romans", "Mayans", "Chinese")
        ),
        HistoryQuestion(
            text = "Who was known as the 'Maid of Orleans'?",
            answers = mutableListOf("Joan of Arc", "Marie Curie", "Catherine the Great", "Queen Elizabeth I")
        ),
        HistoryQuestion(
            text = "What was the name of the ship that carried the Pilgrims to America in 1620?",
            answers = mutableListOf("Mayflower", "Santa Maria", "Beagle", "Endeavour")
        ),
        HistoryQuestion(
            text = "Who was the first Emperor of Rome?",
            answers = listOf("Augustus", "Julius Caesar", "Nero", "Tiberius")
        ),
        HistoryQuestion(
            text = "Which event is known as the start of the French Revolution?",
            answers = listOf(
                "Storming of the Bastille",
                "Reign of Terror",
                "Fall of Napoleon",
                "Estates-General Meeting"
            )
        ),
        HistoryQuestion(
            text = "What was the name of the first manned mission to land on the Moon?",
            answers = listOf("Apollo 11", "Apollo 13", "Gemini 7", "Challenger")
        ),
        HistoryQuestion(
            text = "Who was the leader of the Soviet Union during World War II?",
            answers = listOf("Joseph Stalin", "Vladimir Lenin", "Nikita Khrushchev", "Leonid Brezhnev")
        ),
        HistoryQuestion(
            text = "What year marked the fall of the Berlin Wall?",
            answers = listOf("1989", "1980", "1991", "1979")
        ),
        HistoryQuestion(
            text = "Who discovered America in 1492?",
            answers = listOf("Christopher Columbus", "Amerigo Vespucci", "Leif Erikson", "Ferdinand Magellan")
        ),
        HistoryQuestion(
            text = "What was the name of the treaty that ended World War I?",
            answers = listOf("Treaty of Versailles", "Treaty of Paris", "Treaty of Tordesillas", "Treaty of Ghent")
        ),
        HistoryQuestion(
            text = "Which empire was ruled by Genghis Khan?",
            answers = listOf("Mongol Empire", "Ottoman Empire", "Roman Empire", "Persian Empire")
        ),
        HistoryQuestion(
            text = "What year did the American Civil War start?",
            answers = listOf("1861", "1865", "1850", "1870")
        ),
        HistoryQuestion(
            text = "What was the name of the ship Charles Darwin sailed on during his research?",
            answers = listOf("HMS Beagle", "Mayflower", "Santa Maria", "HMS Victory")
        ),
        HistoryQuestion(
            text = "Who painted the Mona Lisa?",
            answers = listOf("Leonardo da Vinci", "Michelangelo", "Raphael", "Donatello")
        ),
        HistoryQuestion(
            text = "What was the capital of the Byzantine Empire?",
            answers = listOf("Constantinople", "Athens", "Rome", "Alexandria")
        ),
        HistoryQuestion(
            text = "Who wrote the Declaration of Independence?",
            answers = listOf("Thomas Jefferson", "George Washington", "John Adams", "Benjamin Franklin")
        ),
        HistoryQuestion(
            text = "Which country was known as Persia before 1935?",
            answers = listOf("Iran", "Iraq", "Afghanistan", "Turkey")
        ),
        HistoryQuestion(
            text = "What was the name of the first successful English colony in America?",
            answers = listOf("Jamestown", "Plymouth", "Roanoke", "New Amsterdam")
        ),
        HistoryQuestion(
            text = "Who was the first woman to fly solo across the Atlantic Ocean?",
            answers = mutableListOf("Amelia Earhart", "Bessie Coleman", "Harriet Quimby", "Jacqueline Cochran")
        ),
        HistoryQuestion(
            text = "Which country was ruled by the Pharaohs?",
            answers = mutableListOf("Egypt", "Greece", "Rome", "Mesopotamia")
        ),
        HistoryQuestion(
            text = "Who was the famous nurse during the Crimean War?",
            answers = mutableListOf("Florence Nightingale", "Clara Barton", "Mary Seacole", "Edith Cavell")
        ),
        HistoryQuestion(
            text = "Which civilization is known for its hanging gardens, one of the Seven Wonders of the Ancient World?",
            answers = mutableListOf("Babylonian", "Egyptian", "Greek", "Roman")
        ),
        HistoryQuestion(
            text = "What was the name of the famous ship that sank in 1912?",
            answers = mutableListOf("Titanic", "Lusitania", "Andrea Doria", "Carpathia")
        ),
        HistoryQuestion(
            text = "What was the first human-made object to orbit the Earth?",
            answers = mutableListOf("Sputnik 1", "Apollo 11", "Vostok 1", "Explorer 1")
        ),
        HistoryQuestion(
            text = "Which battle marked the turning point in the American Civil War?",
            answers = mutableListOf(
                "Battle of Gettysburg",
                "Battle of Antietam",
                "Battle of Bunker Hill",
                "Battle of Fort Sumter"
            )
        ),
        HistoryQuestion(
            text = "In which year was the United Nations founded?",
            answers = mutableListOf("1945", "1918", "1939", "1950")
        ),
        HistoryQuestion(
            text = "Who was the first female Prime Minister of the United Kingdom?",
            answers = mutableListOf("Margaret Thatcher", "Theresa May", "Indira Gandhi", "Golda Meir")
        ),
        HistoryQuestion(
            text = "Which war was fought between the North and South regions of the United States?",
            answers = mutableListOf("American Civil War", "World War I", "World War II", "Vietnam War")
        ),
        HistoryQuestion(
            text = "Who was the famous inventor known for the light bulb and phonograph?",
            answers = mutableListOf("Thomas Edison", "Alexander Graham Bell", "Nikola Tesla", "Benjamin Franklin")
        )
    )
    private val sportsQuestion: MutableList<SportsQuestion> = mutableListOf(
        SportsQuestion(
            text = "Who won the FIFA World Cup in 2018?",
            answers = mutableListOf("France", "Croatia", "Germany", "Brazil")
        ),
        SportsQuestion(
            text = "Which athlete has won the most Olympic gold medals?",
            answers = mutableListOf("Michael Phelps", "Usain Bolt", "Larisa Latynina", "Carl Lewis")
        ),
        SportsQuestion(
            text = "What is the highest possible break in snooker?",
            answers = mutableListOf("147", "150", "145", "130")
        ),
        SportsQuestion(
            text = "Which country is the birthplace of the sport of rugby?",
            answers = mutableListOf("England", "New Zealand", "Australia", "South Africa")
        ),
        SportsQuestion(
            text = "In which year did the first modern Olympic Games take place?",
            answers = mutableListOf("1896", "1900", "1912", "1924")
        ),
        SportsQuestion(
            text = "Who holds the record for the most goals in World Cup history?",
            answers = listOf("Marta", "Miroslav Klose", "Ronaldo", "Pelé")
        ),
        SportsQuestion(
            text = "Which team won the NBA Championship in 2020?",
            answers = listOf("Los Angeles Lakers", "Miami Heat", "Golden State Warriors", "Toronto Raptors")
        ),
        SportsQuestion(
            text = "Who holds the record for the most Grand Slam singles titles in tennis?",
            answers = listOf("Rafael Nadal", "Roger Federer", "Novak Djokovic", "Pete Sampras")
        ),
        SportsQuestion(
            text = "Which sport is known as the 'king of sports'?",
            answers = listOf("Soccer", "Basketball", "Cricket", "Tennis")
        ),
        SportsQuestion(
            text = "Who was the first woman to win an Olympic gold medal in boxing?",
            answers = listOf("Nicola Adams", "Claressa Shields", "Katie Taylor", "Michaela Walsh")
        ),
        SportsQuestion(
            text = "Which city hosted the 2016 Summer Olympics?",
            answers = listOf("Rio de Janeiro", "London", "Beijing", "Sydney")
        ),
        SportsQuestion(
            text = "Who won the first Super Bowl?",
            answers = listOf("Green Bay Packers", "Kansas City Chiefs", "New England Patriots", "Dallas Cowboys")
        ),
        SportsQuestion(
            text = "Which country is famous for the sport of sumo wrestling?",
            answers = listOf("Japan", "China", "South Korea", "Thailand")
        ),
        SportsQuestion(
            text = "Who holds the record for the most home runs in Major League Baseball?",
            answers = listOf("Barry Bonds", "Hank Aaron", "Babe Ruth", "Alex Rodriguez")
        ),
        SportsQuestion(
            text = "Which country won the 2019 Cricket World Cup?",
            answers = mutableListOf("England", "India", "Australia", "New Zealand")
        ),
        SportsQuestion(
            text = "Who was the first African-American Major League Baseball player?",
            answers = mutableListOf("Jackie Robinson", "Satchel Paige", "Willie Mays", "Hank Aaron")
        ),
        SportsQuestion(
            text = "Which country won the 2014 FIFA World Cup?",
            answers = mutableListOf("Germany", "Argentina", "Brazil", "Spain")
        ),
        SportsQuestion(
            text = "Which sport involves a shuttlecock and rackets?",
            answers = mutableListOf("Badminton", "Tennis", "Table Tennis", "Volleyball")
        ),
        SportsQuestion(
            text = "Who is known as 'The Greatest of All Time' (GOAT) in basketball?",
            answers = mutableListOf("Michael Jordan", "LeBron James", "Kareem Abdul-Jabbar", "Magic Johnson")
        ),
        SportsQuestion(
            text = "What is the maximum number of players on a soccer team on the field at any one time?",
            answers = mutableListOf("11", "10", "12", "9")
        ),
        SportsQuestion(
            text = "Which country has the most gold medals in Winter Olympics history?",
            answers = mutableListOf("Norway", "Germany", "Canada", "USA")
        ),
        SportsQuestion(
            text = "Which sport is Tiger Woods famous for?",
            answers = mutableListOf("Golf", "Tennis", "Football", "Basketball")
        )
    )

    private lateinit var currentQuestion: ScienceQuestion
    private lateinit var currentHistoryQuestion: HistoryQuestion
    private lateinit var currentSportsQuestion: SportsQuestion

    var answers = scienceQuestions[0].answers.shuffled()
    private var questionIndex = 0
    private var points = 0

    private lateinit var timer: CountDownTimer

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        bind = DataBindingUtil.inflate(inflater, R.layout.fragment_quiz, container, false)
        bind.game = this

        timer = object : CountDownTimer(91000, 1000) {
            @SuppressLint("SetTextI18n")
            override fun onTick(p0: Long) {
                bind.timerTextView.text = "${p0 / 1000}s"
            }

            @SuppressLint("SetTextI18n")
            override fun onFinish() {
                bind.timerTextView.text = "Time's Up!"
            }
        }
        timer.start()

        val args = QuizFragmentArgs.fromBundle(requireArguments())
        val btnClicked = args.buttonClicked

        // takes the argument and works accordingly
        when (btnClicked) {
            "scienceBtn" -> {
                scienceQuestions.shuffle()
                setQuestions()
                bind.nextBtn.setOnClickListener {
                    if (questionIndex <= 4 && bind.questionRadioGroup.checkedRadioButtonId != -1) {
                        val ansId = bind.questionRadioGroup.checkedRadioButtonId
                        val radioBtn = bind.root.findViewById<RadioButton>(ansId)
                        val ansText = radioBtn.text.toString()

                        if (ansText == currentQuestion.answers[0]) {
                            points++
                            Log.d("Points", "$points")
                            radioBtn.setBackgroundColor(Color.GREEN)
                        } else {
                            for (i in 0 until bind.questionRadioGroup.childCount) {
                                val radioButton =
                                    bind.questionRadioGroup.getChildAt(i) as RadioButton // Get each RadioButton

                                if (radioButton.text == currentQuestion.answers[0]) {
                                    radioButton.setBackgroundColor(Color.GREEN)
                                    Handler(Looper.getMainLooper()).postDelayed({
                                        radioButton.setBackgroundColor(Color.TRANSPARENT)
                                    }, 600)
                                }
                            }
                            radioBtn.setBackgroundColor(Color.RED)
                        }

                        questionIndex++
                        bind.questionRadioGroup.clearCheck()
                        Handler(Looper.getMainLooper()).postDelayed({
                            setQuestions()
                            radioBtn.setBackgroundColor(Color.TRANSPARENT) // or original color
                        }, 600)
                    }
                }
            }

            "historyBtn" -> {
                historyQuestion.shuffled()
                setHistoryQuestions()
                bind.nextBtn.setOnClickListener {
                    if (questionIndex <= 4 && bind.questionRadioGroup.checkedRadioButtonId != -1) {
                        val ansId = bind.questionRadioGroup.checkedRadioButtonId
                        val radioBtn = bind.root.findViewById<RadioButton>(ansId)
                        val ansText = radioBtn.text.toString()

                        if (ansText == currentHistoryQuestion.answers[0]) {
                            points++
                            Log.d("Points", "$points")
                            radioBtn.setBackgroundColor(Color.GREEN)
                        } else {
                            for (i in 0 until bind.questionRadioGroup.childCount) {
                                val radioButton =
                                    bind.questionRadioGroup.getChildAt(i) as RadioButton // Get each RadioButton

                                if (radioButton.text == currentHistoryQuestion.answers[0]) {
                                    radioButton.setBackgroundColor(Color.GREEN)
                                    Handler(Looper.getMainLooper()).postDelayed({
                                        radioButton.setBackgroundColor(Color.TRANSPARENT)
                                    }, 600)
                                }
                            }
                            radioBtn.setBackgroundColor(Color.RED)
                        }
                        questionIndex++
                        bind.questionRadioGroup.clearCheck()
                        Handler(Looper.getMainLooper()).postDelayed({
                            setHistoryQuestions()
                            radioBtn.setBackgroundColor(Color.TRANSPARENT) // or original color
                        }, 600)
                    }
                }
            }

            "sportsBtn" -> {
                sportsQuestion.shuffled()
                setSportsQuestions()
                bind.nextBtn.setOnClickListener {
                    if (questionIndex <= 4 && bind.questionRadioGroup.checkedRadioButtonId != -1) {
                        val ansId = bind.questionRadioGroup.checkedRadioButtonId
                        val radioBtn = bind.root.findViewById<RadioButton>(ansId)
                        val ansText = radioBtn.text.toString()

                        if (ansText == currentSportsQuestion.answers[0]) {
                            points++
                            Log.d("Points", "$points")
                            radioBtn.setBackgroundColor(Color.GREEN)
                        } else {

                            for (i in 0 until bind.questionRadioGroup.childCount) {
                                val radioButton =
                                    bind.questionRadioGroup.getChildAt(i) as RadioButton // Get each RadioButton
                                if (radioButton.text == currentSportsQuestion.answers[0]) {
                                    // Set the background color to green (correct answer)
                                    radioButton.setBackgroundColor(Color.GREEN)
                                    Handler(Looper.getMainLooper()).postDelayed({
                                        radioButton.setBackgroundColor(Color.TRANSPARENT)
                                    }, 600)
                                }
                            }
                            radioBtn.setBackgroundColor(Color.RED)
                        }
                        questionIndex++
                        bind.questionRadioGroup.clearCheck()
                        Handler(Looper.getMainLooper()).postDelayed({
                            // Reset the background color (e.g., to default)
                            setSportsQuestions()
                            radioBtn.setBackgroundColor(Color.TRANSPARENT) // or original color
                        }, 600)
                    }
                }
            }
        }

        return bind.root
    }

    override fun onDestroy() {
        super.onDestroy()
        timer.cancel()
    }

    private fun setQuestions() {
        currentQuestion = scienceQuestions[questionIndex]
        bind.questionText.text = currentQuestion.text
        answers = currentQuestion.answers.shuffled()
        bind.invalidateAll()
    }

    private fun setHistoryQuestions() {
        currentHistoryQuestion = historyQuestion[questionIndex]
        bind.questionText.text = currentHistoryQuestion.text
        answers = currentHistoryQuestion.answers.shuffled()
        bind.invalidateAll()
    }

    private fun setSportsQuestions() {
        currentSportsQuestion = sportsQuestion[questionIndex]
        bind.questionText.text = currentSportsQuestion.text
        answers = currentSportsQuestion.answers.shuffled()
        bind.invalidateAll()
    }
}