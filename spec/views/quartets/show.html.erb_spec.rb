require 'spec_helper'

describe "quartets/show" do
  before(:each) do
    @quartet = assign(:quartet, stub_model(Quartet))
  end

  it "renders attributes in <p>" do
    render
    # Run the generator again with the --webrat flag if you want to use webrat matchers
  end
end
