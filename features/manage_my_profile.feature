Feature: Manage profile feature
		In order to provide information about myself so that other Singers can find me
        As a Singer
        I want to manage my own profile

		Scenario: Show current first name
				Given I have logged in
				When I go to my profile page
				Then my first name should be shown
				
        Scenario: Update first name
                Given The first name is Bob
                When I changed it to Foo
                Then The the first name should become Foo