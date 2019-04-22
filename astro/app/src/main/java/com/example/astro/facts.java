package com.example.astro;

public class facts {

    String[] facts={"India has the most number of post offices in India","Dr.Rajendra Prasad was the first president of India","Turing award is an equivalent award to Nobel Prize in the field of Computer Science",
            "The Mariana Trench is the deepest point in the world","Russia is the largest country in the world","Monaco has the highest GDP per capita","Only 4 countries - India, U.S.A, China and Russia are space powers","Benazir Bhutto was the first female Prime Minister from an Islamic country","Australia has won the most number of Cricket World Cups",
            "There are 543 Lok Sabha seats in the Parliament of India","Blue Whales are the largest animals to have ever lived on Earth","The average person walks the equivalent of 5 laps around the world during their lifetime."
            ,"The chills you get when listening to music are caused by your brain releasing dopamine, a neurotransmitter that causes pleasure.","Many oranges are green when they’re ripe. Scientists remove their chlorophyll to make them more appealing to North American consumers.",
            "There are over 1,000 adaptations of Shakespeare’s works.","The only word that rhymes with “purple” is “hirple,” which means “to limp awkwardly.” Nothing rhymes with 'woman'.",
            "Bananas are more effective in replenishing electrolytes than Gatorade. They also have serotonin and dopamine—chemicals that help you feel happy.","Honey is a better cough suppressant than over-the-counter cough suppressants.",
            "Simply taking 1 step uses over 200 muscles in the body.","Sarcasm makes you more creative.","56 percent of internet users have googled themselves.","At age 23, Evan Spiegel, the founder of Snapchat, is the world’s youngest billionaire.",
            "When Queen Elizabeth visited the set of Game of Thrones, she refused to sit on the iron throne because she is not allowed to sit on foreign thrones."};
    int i=0;
    int size=facts.length;
    public String nextfact( ){
        i=(i+1)%size;
        return facts[i];
    }
}
