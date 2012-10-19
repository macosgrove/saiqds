require 'spec_helper'

describe "singers/edit" do
  before(:each) do
    @singer = assign(:singer, stub_model(Singer))
  end

  it "renders the edit singer form" do
    render

    # Run the generator again with the --webrat flag if you want to use webrat matchers
    assert_select "form", :action => singers_path(@singer), :method => "post" do
    end
  end
end
