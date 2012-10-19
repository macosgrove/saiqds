require 'spec_helper'

describe "quartets/edit" do
  before(:each) do
    @quartet = assign(:quartet, stub_model(Quartet))
  end

  it "renders the edit quartet form" do
    render

    # Run the generator again with the --webrat flag if you want to use webrat matchers
    assert_select "form", :action => quartets_path(@quartet), :method => "post" do
    end
  end
end
