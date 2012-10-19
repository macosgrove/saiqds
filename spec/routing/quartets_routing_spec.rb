require "spec_helper"

describe QuartetsController do
  describe "routing" do

    it "routes to #index" do
      get("/quartets").should route_to("quartets#index")
    end

    it "routes to #new" do
      get("/quartets/new").should route_to("quartets#new")
    end

    it "routes to #show" do
      get("/quartets/1").should route_to("quartets#show", :id => "1")
    end

    it "routes to #edit" do
      get("/quartets/1/edit").should route_to("quartets#edit", :id => "1")
    end

    it "routes to #create" do
      post("/quartets").should route_to("quartets#create")
    end

    it "routes to #update" do
      put("/quartets/1").should route_to("quartets#update", :id => "1")
    end

    it "routes to #destroy" do
      delete("/quartets/1").should route_to("quartets#destroy", :id => "1")
    end

  end
end
