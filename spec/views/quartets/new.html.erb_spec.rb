require 'spec_helper'

describe "quartets/new" do
  before(:each) do
    assign(:quartet, stub_model(Quartet).as_new_record)
  end

  it "renders new quartet form" do
    render

    # Run the generator again with the --webrat flag if you want to use webrat matchers
    assert_select "form", :action => quartets_path, :method => "post" do
    end
  end
end
