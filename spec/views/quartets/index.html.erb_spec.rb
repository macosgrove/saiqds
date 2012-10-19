require 'spec_helper'

describe "quartets/index" do
  before(:each) do
    assign(:quartets, [
      stub_model(Quartet),
      stub_model(Quartet)
    ])
  end

  it "renders a list of quartets" do
    render
    # Run the generator again with the --webrat flag if you want to use webrat matchers
  end
end
